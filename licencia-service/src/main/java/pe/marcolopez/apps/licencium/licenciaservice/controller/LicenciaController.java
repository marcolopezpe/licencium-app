package pe.marcolopez.apps.licencium.licenciaservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pe.marcolopez.apps.licencium.licenciaservice.dto.*;
import pe.marcolopez.apps.licencium.licenciaservice.producer.LicenciaProducer;
import pe.marcolopez.apps.licencium.licenciaservice.service.LicenciaService;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("licencias")
@AllArgsConstructor
public class LicenciaController {

    private final LicenciaService licenciaService;
    private final LicenciaProducer licenciaProducer;

    @GetMapping
    public ResponseEntity<List<LicenciaDTO>> findAll() {
        List<LicenciaDTO> licenciaDTOList = licenciaService.findAll();

        if (CollectionUtils.isEmpty(licenciaDTOList)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(licenciaDTOList);
    }

    @GetMapping("/filters")
    public ResponseEntity<List<LicenciaDTO>> findAllByFilters(@RequestParam String numeroDocumento,
                                                              @RequestParam String categoria,
                                                              @RequestParam String numero) {
        List<LicenciaDTO> licenciaDTOList = licenciaService.findAllByFilters(numeroDocumento, categoria, numero);

        if (CollectionUtils.isEmpty(licenciaDTOList)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(licenciaDTOList);
    }

    @GetMapping("/numero-documento/{numeroDocumento}")
    public ResponseEntity<LicenciaDTO> validate(@PathVariable String numeroDocumento) {
        LicenciaDTO licenciaDTO = licenciaService.validate(numeroDocumento);

        if (licenciaDTO == null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(licenciaDTO);
    }

    @PostMapping("/generate")
    public ResponseEntity<?> generate(@Validated @RequestBody LicenciaGenerateDTO licenciaGenerateDTO) {
        LicenciaDTO licenciaDTO = licenciaService.generate(licenciaGenerateDTO);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{numeroLicencia}")
                .buildAndExpand(licenciaDTO.getNumeroLicencia())
                .toUri();

        licenciaDTO.setAccion(Accion.GENERATED.getValue());

        return ResponseEntity.created(location).build();
    }

    @PostMapping
    public ResponseEntity<?> create(@Validated @RequestBody LicenciaCreateDTO licenciaCreateDTO) {
        LicenciaDTO licenciaDTO = licenciaService.create(licenciaCreateDTO);
        licenciaDTO.setAccion(Accion.CREATED.getValue());
        licenciaProducer.send(licenciaDTO);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(licenciaDTO.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{numeroLicencia}")
    public ResponseEntity<LicenciaDTO> update(@PathVariable String numeroLicencia,
                                              @Validated @RequestBody LicenciaUpdateDTO licenciaUpdateDTO) {
        LicenciaDTO licenciaDTO = licenciaService.findByNumeroLicencia(numeroLicencia);

        if (licenciaDTO == null) {
            throw new RuntimeException("Numero de Licencia %s no existe!".formatted(numeroLicencia));
        }

        licenciaDTO.setAccion(Accion.UPDATED.getValue());
        licenciaProducer.send(licenciaDTO);

        LicenciaDTO licenciaUpdated = licenciaService.update(licenciaUpdateDTO);
        return ResponseEntity.ok(licenciaUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        LicenciaDTO licenciaDTO = licenciaService.findById(UUID.fromString(id));
        licenciaDTO.setAccion(Accion.DELETED.getValue());
        licenciaService.delete(UUID.fromString(id));
        licenciaProducer.send(licenciaDTO);
        return ResponseEntity.ok().build();
    }
}

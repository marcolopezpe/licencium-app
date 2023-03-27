package pe.marcolopez.apps.licencium.licenciaservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pe.marcolopez.apps.licencium.licenciaservice.dto.LicenciaCreateDTO;
import pe.marcolopez.apps.licencium.licenciaservice.dto.LicenciaDTO;
import pe.marcolopez.apps.licencium.licenciaservice.dto.LicenciaGenerateDTO;
import pe.marcolopez.apps.licencium.licenciaservice.dto.LicenciaUpdateDTO;
import pe.marcolopez.apps.licencium.licenciaservice.service.LicenciaService;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/licencias")
@AllArgsConstructor
public class LicenciaController {

    private final LicenciaService licenciaService;

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

        return ResponseEntity.created(location).build();
    }

    @PostMapping
    public ResponseEntity<?> create(@Validated @RequestBody LicenciaCreateDTO licenciaCreateDTO) {
        LicenciaDTO licenciaDTO = licenciaService.create(licenciaCreateDTO);

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

        LicenciaDTO licenciaUpdated = licenciaService.update(licenciaUpdateDTO);
        return ResponseEntity.ok(licenciaUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        licenciaService.delete(UUID.fromString(id));
        return ResponseEntity.ok().build();
    }
}

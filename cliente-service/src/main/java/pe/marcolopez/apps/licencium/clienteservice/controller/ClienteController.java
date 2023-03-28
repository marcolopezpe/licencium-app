package pe.marcolopez.apps.licencium.clienteservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pe.marcolopez.apps.licencium.clienteservice.dto.ClienteCreateDTO;
import pe.marcolopez.apps.licencium.clienteservice.dto.ClienteDTO;
import pe.marcolopez.apps.licencium.clienteservice.dto.ClienteUpdateDTO;
import pe.marcolopez.apps.licencium.clienteservice.service.ClienteService;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("clientes")
@AllArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findAll() {
        List<ClienteDTO> clienteDTOList = clienteService.findAll();

        if (CollectionUtils.isEmpty(clienteDTOList)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(clienteDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable String id) {
        ClienteDTO clienteDTO = clienteService.findbyId(UUID.fromString(id));

        if (clienteDTO == null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(clienteDTO);
    }

    @GetMapping("/numero-documento/{numeroDocumento}")
    public ResponseEntity<ClienteDTO> findByNumeroDocumento(@PathVariable String numeroDocumento) {
        ClienteDTO clienteDTO = clienteService.findByNumeroDocumento(numeroDocumento);

        if (clienteDTO == null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(clienteDTO);
    }

    @PostMapping
    public ResponseEntity<?> create(@Validated @RequestBody ClienteCreateDTO clienteCreateDTO) {
        ClienteDTO clienteDTO = clienteService.create(clienteCreateDTO);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(clienteDTO.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{numeroDocumento}")
    public ResponseEntity<ClienteDTO> update(@PathVariable String numeroDocumento,
                                             @Validated @RequestBody ClienteUpdateDTO clienteUpdateDTO) {
        ClienteDTO clienteDTO = clienteService.findByNumeroDocumento(numeroDocumento);

        if (clienteDTO == null) {
            throw new RuntimeException("Cliente con Numero Documento %s no existe!".formatted(numeroDocumento));
        }

        ClienteDTO clienteUpdated = clienteService.update(numeroDocumento, clienteUpdateDTO);
        return ResponseEntity.ok(clienteUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        clienteService.delete(UUID.fromString(id));
        return ResponseEntity.ok().build();
    }
}

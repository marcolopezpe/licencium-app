package pe.marcolopez.apps.licencium.usuarioservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pe.marcolopez.apps.licencium.usuarioservice.dto.Accion;
import pe.marcolopez.apps.licencium.usuarioservice.dto.UsuarioCreateDTO;
import pe.marcolopez.apps.licencium.usuarioservice.dto.UsuarioDTO;
import pe.marcolopez.apps.licencium.usuarioservice.dto.UsuarioUpdateDTO;
import pe.marcolopez.apps.licencium.usuarioservice.producer.UsuarioProducer;
import pe.marcolopez.apps.licencium.usuarioservice.service.UsuarioService;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("usuarios")
@AllArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final UsuarioProducer usuarioProducer;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> findAll() {
        List<UsuarioDTO> usuarioDTOList = usuarioService.findAll();

        if (CollectionUtils.isEmpty(usuarioDTOList)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(usuarioDTOList);
    }

    @PostMapping
    public ResponseEntity<?> create(@Validated @RequestBody UsuarioCreateDTO usuarioCreateDTO) {
        UsuarioDTO created = usuarioService.create(usuarioCreateDTO);
        created.setAccion(Accion.CREATED.getValue());
        usuarioProducer.send(created);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<UsuarioDTO> update(@PathVariable String id,
                                             @Validated @RequestBody UsuarioUpdateDTO usuarioUpdateDTO) {
        UsuarioDTO updated = usuarioService.update(UUID.fromString(id), usuarioUpdateDTO);
        updated.setAccion(Accion.UPDATED.getValue());
        usuarioProducer.send(updated);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        UsuarioDTO deleted = usuarioService.findById(UUID.fromString(id));
        deleted.setAccion(Accion.DELETED.getValue());
        usuarioService.delete(UUID.fromString(id));
        usuarioProducer.send(deleted);
        return ResponseEntity.ok().build();
    }
}

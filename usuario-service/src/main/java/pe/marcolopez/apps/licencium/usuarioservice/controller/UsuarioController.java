package pe.marcolopez.apps.licencium.usuarioservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pe.marcolopez.apps.licencium.usuarioservice.dto.UsuarioCreateDTO;
import pe.marcolopez.apps.licencium.usuarioservice.dto.UsuarioDTO;
import pe.marcolopez.apps.licencium.usuarioservice.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("usuarios")
@AllArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> findAll() {
        List<UsuarioDTO> usuarioDTOList = usuarioService.findAll();

        if (CollectionUtils.isEmpty(usuarioDTOList)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(usuarioDTOList);
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> create(@Validated @RequestBody UsuarioCreateDTO usuarioCreateDTO) {
        UsuarioDTO usuarioDTOCreated = usuarioService.create(usuarioCreateDTO);
        return ResponseEntity.ok(usuarioDTOCreated);
    }
}

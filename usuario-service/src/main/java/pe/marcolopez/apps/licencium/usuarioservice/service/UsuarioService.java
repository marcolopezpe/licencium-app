package pe.marcolopez.apps.licencium.usuarioservice.service;

import pe.marcolopez.apps.licencium.usuarioservice.dto.UsuarioCreateDTO;
import pe.marcolopez.apps.licencium.usuarioservice.dto.UsuarioDTO;
import pe.marcolopez.apps.licencium.usuarioservice.dto.UsuarioUpdateDTO;

import java.util.List;
import java.util.UUID;

public interface UsuarioService {

    UsuarioDTO create(UsuarioCreateDTO usuarioCreateDTO);

    UsuarioDTO update(UUID id, UsuarioUpdateDTO usuarioUpdateDTO);

    void delete(UUID id);

    UsuarioDTO findByEmail(String email);

    UsuarioDTO findById(UUID id);

    List<UsuarioDTO> findAll();
}

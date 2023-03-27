package pe.marcolopez.apps.licencium.usuarioservice.service;

import pe.marcolopez.apps.licencium.usuarioservice.dto.UsuarioDTO;

import java.util.List;

public interface UsuarioService {

    UsuarioDTO findByEmail(String email);

    List<UsuarioDTO> findAll();
}

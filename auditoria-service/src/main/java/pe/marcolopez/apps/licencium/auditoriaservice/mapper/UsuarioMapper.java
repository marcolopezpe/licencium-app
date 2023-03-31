package pe.marcolopez.apps.licencium.auditoriaservice.mapper;

import org.springframework.stereotype.Component;
import pe.marcolopez.apps.licencium.auditoriaservice.data.UsuarioDocument;
import pe.marcolopez.apps.licencium.auditoriaservice.dto.UsuarioDTO;

import java.util.UUID;

@Component
public class UsuarioMapper {

    public UsuarioDocument toUsuarioDocument(UsuarioDTO usuarioDTO) {
        UsuarioDocument usuarioDocument = new UsuarioDocument();
        usuarioDocument.setId(usuarioDTO.getId());
        usuarioDocument.setNombres(usuarioDTO.getNombres());
        usuarioDocument.setApellidos(usuarioDTO.getApellidos());
        usuarioDocument.setNombreUsuario(usuarioDTO.getNombreUsuario());
        usuarioDocument.setContrasena(usuarioDTO.getContrasena());
        usuarioDocument.setEmail(usuarioDTO.getEmail());
        usuarioDocument.setUsuarioCreacion(usuarioDTO.getUsuarioCreacion());
        usuarioDocument.setFechaCreacion(usuarioDTO.getFechaCreacion());
        usuarioDocument.setAccion(usuarioDTO.getAccion());
        return usuarioDocument;
    }
}

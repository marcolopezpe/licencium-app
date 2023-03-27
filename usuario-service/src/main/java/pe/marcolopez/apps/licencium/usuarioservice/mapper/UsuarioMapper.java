package pe.marcolopez.apps.licencium.usuarioservice.mapper;

import org.springframework.stereotype.Component;
import pe.marcolopez.apps.licencium.usuarioservice.dto.UsuarioDTO;
import pe.marcolopez.apps.licencium.usuarioservice.entity.UsuarioEntity;

@Component
public class UsuarioMapper {

    public UsuarioEntity mapToEntity(UsuarioDTO usuarioDTO) {
        return UsuarioEntity.builder()
                .id(usuarioDTO.getId())
                .nombres(usuarioDTO.getNombres())
                .apellidos(usuarioDTO.getApellidos())
                .nombreUsuario(usuarioDTO.getNombreUsuario())
                .contrasena(usuarioDTO.getContrasena())
                .email(usuarioDTO.getEmail())
                .build();
    }

    public UsuarioDTO mapToDTO(UsuarioEntity usuarioEntity) {
        return UsuarioDTO.builder()
                .id(usuarioEntity.getId())
                .nombres(usuarioEntity.getNombres())
                .apellidos(usuarioEntity.getApellidos())
                .nombreUsuario(usuarioEntity.getNombreUsuario())
                .contrasena(usuarioEntity.getContrasena())
                .email(usuarioEntity.getEmail())
                .build();
    }
}

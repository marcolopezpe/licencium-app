package pe.marcolopez.apps.licencium.usuarioservice.mapper;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import pe.marcolopez.apps.licencium.usuarioservice.dto.UsuarioCreateDTO;
import pe.marcolopez.apps.licencium.usuarioservice.dto.UsuarioDTO;
import pe.marcolopez.apps.licencium.usuarioservice.dto.UsuarioUpdateDTO;
import pe.marcolopez.apps.licencium.usuarioservice.entity.UsuarioEntity;

@Component
@AllArgsConstructor
public class UsuarioMapper {

    private final BCryptPasswordEncoder passwordEncoder;

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

    public UsuarioEntity mapToEntity(UsuarioCreateDTO usuarioDTO) {
        return UsuarioEntity.builder()
                .nombres(usuarioDTO.getNombres())
                .apellidos(usuarioDTO.getApellidos())
                .nombreUsuario(usuarioDTO.getNombreUsuario())
                .contrasena(passwordEncoder.encode(usuarioDTO.getContrasena()))
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

    public void mapToUpdate(UsuarioUpdateDTO usuarioUpdateDTO, UsuarioEntity usuarioEntity) {
        usuarioEntity.setNombres(usuarioUpdateDTO.getNombres());
        usuarioEntity.setApellidos(usuarioUpdateDTO.getApellidos());
        usuarioEntity.setNombreUsuario(usuarioUpdateDTO.getNombreUsuario());
        usuarioEntity.setContrasena(usuarioUpdateDTO.getContrasena());
        usuarioEntity.setEmail(usuarioUpdateDTO.getEmail());
    }
}

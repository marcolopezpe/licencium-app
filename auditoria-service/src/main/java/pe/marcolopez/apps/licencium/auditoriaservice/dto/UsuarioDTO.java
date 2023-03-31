package pe.marcolopez.apps.licencium.auditoriaservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioDTO {

    private String id;
    private String nombres;
    private String apellidos;
    private String nombreUsuario;
    private String contrasena;
    private String email;
    private String usuarioCreacion;
    private Long fechaCreacion;
    private Integer accion;
}

package pe.marcolopez.apps.licencium.auditservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioCreateDTO {

    private String nombres;
    private String apellidos;
    private String nombreUsuario;
    private String contrasena;
    private String email;
}

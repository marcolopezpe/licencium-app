package pe.marcolopez.apps.licencium.usuarioservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    private UUID id;
    private String nombres;
    private String apellidos;
    private String nombreUsuario;
    private String contrasena;
    private String email;

    @JsonIgnore
    private String usuarioCreacion;
    @JsonIgnore
    private Long fechaCreacion;
    @JsonIgnore
    private Integer accion;
}

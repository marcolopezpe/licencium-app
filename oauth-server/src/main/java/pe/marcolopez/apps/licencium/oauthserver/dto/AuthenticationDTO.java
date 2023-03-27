package pe.marcolopez.apps.licencium.oauthserver.dto;

import lombok.Data;

@Data
public class AuthenticationDTO {

    private String nombreUsuario;
    private String contrasena;
}

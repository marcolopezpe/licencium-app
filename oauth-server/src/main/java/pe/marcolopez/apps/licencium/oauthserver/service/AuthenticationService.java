package pe.marcolopez.apps.licencium.oauthserver.service;

import pe.marcolopez.apps.licencium.oauthserver.dto.AuthenticationDTO;

public interface AuthenticationService {

    String authenticate(AuthenticationDTO authenticationDTO);
}

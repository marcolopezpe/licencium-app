package pe.marcolopez.apps.licencium.oauthserver.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.marcolopez.apps.licencium.oauthserver.dto.AuthenticationDTO;
import pe.marcolopez.apps.licencium.oauthserver.service.AuthenticationService;

@RestController
@RequestMapping("/oauth")
@AllArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody AuthenticationDTO authenticationDTO) {
        return ResponseEntity.ok(authenticationService.authenticate(authenticationDTO));
    }
}

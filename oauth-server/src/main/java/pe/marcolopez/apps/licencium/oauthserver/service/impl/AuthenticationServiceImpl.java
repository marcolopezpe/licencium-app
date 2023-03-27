package pe.marcolopez.apps.licencium.oauthserver.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.marcolopez.apps.licencium.oauthserver.config.JwtTokenService;
import pe.marcolopez.apps.licencium.oauthserver.dto.AuthenticationDTO;
import pe.marcolopez.apps.licencium.oauthserver.entity.UsuarioEntity;
import pe.marcolopez.apps.licencium.oauthserver.repository.UsuarioRepository;
import pe.marcolopez.apps.licencium.oauthserver.service.AuthenticationService;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenService jwtTokenService;

    @Override
    public String authenticate(AuthenticationDTO authenticationDTO) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationDTO.getNombreUsuario(),
                        authenticationDTO.getContrasena()
                )
        );

        UsuarioEntity usuarioEntity = usuarioRepository
                .findByNombreUsuarioContainingIgnoreCase(authenticationDTO.getNombreUsuario())
                .orElse(null);

        if (usuarioEntity == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        return jwtTokenService.generateToken(usuarioEntity);
    }
}

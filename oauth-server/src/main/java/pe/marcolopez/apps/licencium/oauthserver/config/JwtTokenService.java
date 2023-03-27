package pe.marcolopez.apps.licencium.oauthserver.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import pe.marcolopez.apps.licencium.oauthserver.entity.UsuarioEntity;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.Map;

@Service
public class JwtTokenService {

    @Value("${config.jwt.privateKey:licencium}")
    private String privateKey;
    @Value("${config.jwt.accessTokenValidity:10}")
    private Long accessTokenValidity;

    public String generateToken(UserDetails userDetails) {
        return generateToken(Map.of(), userDetails);
    }

    private String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        UsuarioEntity usuarioEntity = (UsuarioEntity) userDetails;

        extraClaims.put("email", usuarioEntity.getEmail());
        extraClaims.put("nombres", usuarioEntity.getNombres());
        extraClaims.put("apellidos", usuarioEntity.getApellidos());
        extraClaims.put("nombreUsuario", usuarioEntity.getNombreUsuario());

        return Jwts.builder()
                .addClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * accessTokenValidity))
                .signWith(getSignKey())
                .compact();
    }

    private Key getSignKey() {
        return Keys.hmacShaKeyFor(Base64.getEncoder().encode(privateKey.getBytes()));
    }
}

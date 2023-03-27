package pe.marcolopez.apps.licencium.oauthserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.marcolopez.apps.licencium.oauthserver.entity.UsuarioEntity;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, UUID> {

    Optional<UsuarioEntity> findByNombreUsuario(String nombreUsuario);
}

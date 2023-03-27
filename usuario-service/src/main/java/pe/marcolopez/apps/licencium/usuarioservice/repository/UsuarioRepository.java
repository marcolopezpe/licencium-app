package pe.marcolopez.apps.licencium.usuarioservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.marcolopez.apps.licencium.usuarioservice.entity.UsuarioEntity;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, UUID> {

    UsuarioEntity findByEmail(String email);
}

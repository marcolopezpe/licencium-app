package pe.marcolopez.apps.licencium.clienteservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.marcolopez.apps.licencium.clienteservice.entity.ClienteEntity;

import java.util.Optional;
import java.util.UUID;

public interface ClienteRepository extends JpaRepository<ClienteEntity, UUID> {

    Optional<ClienteEntity> findByNumeroDocumento(String numeroDocumento);
}

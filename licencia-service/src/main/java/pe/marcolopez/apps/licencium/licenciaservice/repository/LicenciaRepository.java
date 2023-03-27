package pe.marcolopez.apps.licencium.licenciaservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.marcolopez.apps.licencium.licenciaservice.entity.LicenciaEntity;

import java.util.List;
import java.util.UUID;

public interface LicenciaRepository extends JpaRepository<LicenciaEntity, UUID> {

    LicenciaEntity findByNumeroLicencia(String numeroLicencia);

    @Query("""
            SELECT l
            FROM LicenciaEntity l
            WHERE l.clienteEntity.numeroDocumento LIKE '%'+:documentoCliente+'%'
                OR l.categoria LIKE '%'+:categoria+'%'
                OR l.numeroLicencia LIKE '%'+:numero+'%'
            """)
    List<LicenciaEntity> findAllByFilters(@Param("documentoCliente") String documentoCliente,
                                          @Param("categoria") String categoria,
                                          @Param("numero") String numero);

    @Query("""
            SELECT l
            FROM LicenciaEntity l
            WHERE l.clienteEntity.numeroDocumento LIKE ''+:numeroDocumento+'%'
            """)
    LicenciaEntity validate(@Param("numeroDocumento") String numeroDocumento);
}

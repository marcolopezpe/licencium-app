package pe.marcolopez.apps.licencium.auditoriaservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pe.marcolopez.apps.licencium.auditoriaservice.data.LicenciaDocument;

public interface LicenciaRepository extends MongoRepository<LicenciaDocument, String> {
}

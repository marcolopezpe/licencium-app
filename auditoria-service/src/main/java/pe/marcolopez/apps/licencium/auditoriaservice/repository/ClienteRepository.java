package pe.marcolopez.apps.licencium.auditoriaservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pe.marcolopez.apps.licencium.auditoriaservice.data.ClienteDocument;

public interface ClienteRepository extends MongoRepository<ClienteDocument, String> {
}

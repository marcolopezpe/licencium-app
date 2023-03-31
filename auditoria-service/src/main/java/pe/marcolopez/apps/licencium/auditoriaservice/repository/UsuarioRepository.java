package pe.marcolopez.apps.licencium.auditoriaservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pe.marcolopez.apps.licencium.auditoriaservice.data.UsuarioDocument;

public interface UsuarioRepository extends MongoRepository<UsuarioDocument, String> {
}

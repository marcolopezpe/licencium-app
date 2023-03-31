package pe.marcolopez.apps.licencium.auditoriaservice.data;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@Document("licencia")
public class LicenciaDocument {

    @Id
    @Field("_id")
    private String _id;
    @Field("id")
    private String id;
    private String numeroLicencia;
    private String clase;
    private Long fechaExpedicion;
    private String categoria;
    private Long fechaRevalidacion;
    private String restricciones;
    private String clienteNumeroDocumento;
    private String usuarioCreacion;
    private Long fechaCreacion;
    private Integer accion;
}

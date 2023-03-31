package pe.marcolopez.apps.licencium.auditoriaservice.data;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@Document("cliente")
public class ClienteDocument {

    @Id
    @Field("_id")
    private String _id;
    @Field("id")
    private String id;
    private String apellidos;
    private String nombres;
    private String numeroDocumento;
    private Long fechaNacimiento;
    private String domicilio;
    private String grupoFactorSanguineo;
    private Boolean donacionOrganos;
    private String usuarioCreacion;
    private Long fechaCreacion;
    private Integer accion;
}

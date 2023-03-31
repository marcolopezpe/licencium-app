package pe.marcolopez.apps.licencium.auditoriaservice.data;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@Document("usuario")
public class UsuarioDocument {

    @Id
    @Field("_id")
    private String _id;
    @Field("id")
    private String id;
    private String nombres;
    private String apellidos;
    private String nombreUsuario;
    private String contrasena;
    private String email;
    private String usuarioCreacion;
    private Long fechaCreacion;
    private Integer accion;
}

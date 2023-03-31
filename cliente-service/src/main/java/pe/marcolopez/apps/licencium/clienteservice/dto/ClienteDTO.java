package pe.marcolopez.apps.licencium.clienteservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteDTO {

    private UUID id;
    private String apellidos;
    private String nombres;
    private String numeroDocumento;
    private Long fechaNacimiento;
    private String domicilio;
    private String grupoFactorSanguineo;
    private Boolean donacionOrganos;

    @JsonIgnore
    private String usuarioCreacion;
    @JsonIgnore
    private Long fechaCreacion;
    @JsonIgnore
    private Integer accion;
}

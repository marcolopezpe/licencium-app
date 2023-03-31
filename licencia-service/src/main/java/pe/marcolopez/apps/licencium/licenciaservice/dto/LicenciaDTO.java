package pe.marcolopez.apps.licencium.licenciaservice.dto;

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
public class LicenciaDTO {

    private UUID id;
    private String numeroLicencia;
    private String clase;
    private Long fechaExpedicion;
    private String categoria;
    private Long fechaRevalidacion;
    private String restricciones;
    private ClienteDTO cliente;

    @JsonIgnore
    private String clienteNumeroDocumento;
    @JsonIgnore
    private String usuarioCreacion;
    @JsonIgnore
    private Long fechaCreacion;
    @JsonIgnore
    private Integer accion;
}

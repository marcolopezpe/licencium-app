package pe.marcolopez.apps.licencium.auditoriaservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LicenciaDTO {

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

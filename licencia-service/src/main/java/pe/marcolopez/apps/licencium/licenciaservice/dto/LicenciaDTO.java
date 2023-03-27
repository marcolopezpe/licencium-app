package pe.marcolopez.apps.licencium.licenciaservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LicenciaDTO {

    private UUID id;
    private String numeroLicencia;
    private String clase;
    private LocalDate fechaExpedicion;
    private String categoria;
    private LocalDate fechaRevalidacion;
    private String restricciones;
    private ClienteDTO cliente;
}

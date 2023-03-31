package pe.marcolopez.apps.licencium.licenciaservice.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
public class LicenciaGenerateDTO {

    @NotEmpty
    private String numeroLicencia;
    @NotEmpty
    private String clase;
    @NotNull
    private Long fechaExpedicion;
    @NotEmpty
    private String categoria;
    @NotNull
    private Long fechaRevalidacion;
    @NotEmpty
    private String restricciones;
    @NotEmpty
    private String numeroDocumento;
}

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
public class LicenciaCreateDTO {

    @NotEmpty
    private String numeroLicencia;
    @NotEmpty
    private String clase;
    @NotEmpty
    private LocalDate fechaExpedicion;
    @NotEmpty
    private String categoria;
    @NotEmpty
    private LocalDate fechaRevalidacion;
    @NotEmpty
    private String restricciones;
    @NotNull
    private String clienteNumeroDocumento;
}

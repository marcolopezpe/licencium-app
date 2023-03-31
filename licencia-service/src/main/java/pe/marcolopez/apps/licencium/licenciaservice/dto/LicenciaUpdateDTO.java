package pe.marcolopez.apps.licencium.licenciaservice.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.marcolopez.apps.licencium.licenciaservice.dto.validators.DateLong;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LicenciaUpdateDTO {


    private UUID id;
    @NotEmpty
    private String numeroLicencia;
    @NotEmpty
    private String clase;
    @NotNull
    @DateLong
    private Long fechaExpedicion;
    @NotEmpty
    private String categoria;
    @NotNull
    @DateLong
    private Long fechaRevalidacion;
    @NotEmpty
    private String restricciones;
    @NotEmpty
    private UUID clienteId;
}

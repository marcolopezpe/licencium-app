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
public class ClienteUpdateDTO {

    @NotEmpty
    private String apellidos;
    @NotEmpty
    private String nombres;
    @NotEmpty
    private String numeroDocumento;
    @NotEmpty
    private LocalDate fechaNacimiento;
    @NotEmpty
    private String domicilio;
    @NotEmpty
    private String grupoFactorSanguineo;
    @NotEmpty
    private Boolean donacionOrganos;
}

package pe.marcolopez.apps.licencium.clienteservice.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.marcolopez.apps.licencium.clienteservice.dto.validators.DateLong;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteCreateDTO {

    @NotEmpty
    private String apellidos;
    @NotEmpty
    private String nombres;
    @NotEmpty
    private String numeroDocumento;
    @NotNull
    @DateLong
    private Long fechaNacimiento;
    @NotEmpty
    private String domicilio;
    @NotEmpty
    private String grupoFactorSanguineo;
    @NotNull
    private Boolean donacionOrganos;
}

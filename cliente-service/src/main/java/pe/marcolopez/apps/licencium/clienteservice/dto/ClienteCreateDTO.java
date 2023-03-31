package pe.marcolopez.apps.licencium.clienteservice.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Long fechaNacimiento;
    @NotEmpty
    private String domicilio;
    @NotEmpty
    private String grupoFactorSanguineo;
    @NotNull
    private Boolean donacionOrganos;
}

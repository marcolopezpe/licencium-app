package pe.marcolopez.apps.licencium.clienteservice.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Long fechaNacimiento;
    @NotEmpty
    private String domicilio;
    @NotEmpty
    private String grupoFactorSanguineo;
    @NotEmpty
    private Boolean donacionOrganos;
}

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
public class ClienteDTO {

    private UUID id;
    private String apellidos;
    private String nombres;
    private String numeroDocumento;
    private LocalDate fechaNacimiento;
    private String domicilio;
    private String grupoFactorSanguineo;
    private Boolean donacionOrganos;
}

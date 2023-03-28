package pe.marcolopez.apps.licencium.clienteservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@Table(name = "tb_cliente")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String apellidos;
    private String nombres;
    private String numeroDocumento;
    @Column(columnDefinition = "DATE")
    private LocalDate fechaNacimiento;
    private String domicilio;
    private String grupoFactorSanguineo;
    private Boolean donacionOrganos;
}

package pe.marcolopez.apps.licencium.licenciaservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@Table(name = "tb_licencia")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LicenciaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String numeroLicencia;
    private String clase;
    @Column(columnDefinition = "DATE")
    private LocalDate fechaExpedicion;
    private String categoria;
    @Column(columnDefinition = "DATE")
    private LocalDate fechaRevalidacion;
    private String restricciones;
    @OneToOne(targetEntity = ClienteEntity.class)
    @JoinColumn(name = "cliente_id")
    private ClienteEntity clienteEntity;
}

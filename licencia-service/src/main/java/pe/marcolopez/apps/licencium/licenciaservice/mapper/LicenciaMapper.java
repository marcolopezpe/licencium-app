package pe.marcolopez.apps.licencium.licenciaservice.mapper;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pe.marcolopez.apps.licencium.licenciaservice.dto.*;
import pe.marcolopez.apps.licencium.licenciaservice.entity.LicenciaEntity;
import pe.marcolopez.apps.licencium.licenciaservice.service.ClienteProxyService;

@Slf4j
@Component
@AllArgsConstructor
public class LicenciaMapper {

    private final ClienteProxyService clienteProxyService;

    public LicenciaDTO mapToDTO(LicenciaEntity licenciaEntity) {
        return LicenciaDTO.builder()
                .id(licenciaEntity.getId())
                .numeroLicencia(licenciaEntity.getNumeroLicencia())
                .clase(licenciaEntity.getClase())
                .fechaExpedicion(licenciaEntity.getFechaExpedicion())
                .categoria(licenciaEntity.getCategoria())
                .fechaRevalidacion(licenciaEntity.getFechaRevalidacion())
                .restricciones(licenciaEntity.getRestricciones())
                .cliente(
                        clienteProxyService.findByNumeroDocumento(licenciaEntity.getClienteNumeroDocumento())
                )
                .build();
    }

    public LicenciaEntity mapToEntity(LicenciaDTO licenciaDTO) {
        return LicenciaEntity.builder()
                .id(licenciaDTO.getId())
                .numeroLicencia(licenciaDTO.getNumeroLicencia())
                .clase(licenciaDTO.getClase())
                .fechaExpedicion(licenciaDTO.getFechaExpedicion())
                .categoria(licenciaDTO.getCategoria())
                .fechaRevalidacion(licenciaDTO.getFechaRevalidacion())
                .restricciones(licenciaDTO.getRestricciones())
                .clienteNumeroDocumento(licenciaDTO.getCliente().getNumeroDocumento())
                .build();
    }

    public LicenciaEntity mapToCreateEntity(LicenciaCreateDTO licenciaCreateDTO) {
        return LicenciaEntity.builder()
                .numeroLicencia(licenciaCreateDTO.getNumeroLicencia())
                .clase(licenciaCreateDTO.getClase())
                .fechaExpedicion(licenciaCreateDTO.getFechaExpedicion())
                .categoria(licenciaCreateDTO.getCategoria())
                .fechaRevalidacion(licenciaCreateDTO.getFechaRevalidacion())
                .restricciones(licenciaCreateDTO.getRestricciones())
                .build();
    }

    public LicenciaEntity mapToGenerateEntity(LicenciaGenerateDTO licenciaGenerateDTO) {
        return LicenciaEntity.builder()
                .numeroLicencia(licenciaGenerateDTO.getNumeroLicencia())
                .clase(licenciaGenerateDTO.getClase())
                .fechaExpedicion(licenciaGenerateDTO.getFechaExpedicion())
                .categoria(licenciaGenerateDTO.getCategoria())
                .fechaRevalidacion(licenciaGenerateDTO.getFechaRevalidacion())
                .restricciones(licenciaGenerateDTO.getRestricciones())
                .build();
    }

    public void mapToUpdate(LicenciaUpdateDTO licenciaUpdateDTO, LicenciaEntity licenciaEntity) {
        licenciaEntity.setClase(licenciaEntity.getClase());
        licenciaEntity.setFechaExpedicion(licenciaUpdateDTO.getFechaExpedicion());
        licenciaEntity.setCategoria(licenciaUpdateDTO.getCategoria());
        licenciaEntity.setFechaRevalidacion(licenciaUpdateDTO.getFechaRevalidacion());
        licenciaEntity.setRestricciones(licenciaUpdateDTO.getRestricciones());
    }
}

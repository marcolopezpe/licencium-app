package pe.marcolopez.apps.licencium.licenciaservice.mapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pe.marcolopez.apps.licencium.licenciaservice.dto.*;
import pe.marcolopez.apps.licencium.licenciaservice.entity.LicenciaEntity;
import pe.marcolopez.apps.licencium.licenciaservice.service.ClienteProxyService;
import pe.marcolopez.apps.licencium.licenciaservice.util.ConvertUtil;

@Slf4j
@Component
@RequiredArgsConstructor
public class LicenciaMapper {

    private final ClienteProxyService clienteProxyService;

    public LicenciaDTO mapToDTO(LicenciaEntity licenciaEntity) {

        return LicenciaDTO.builder()
                .id(licenciaEntity.getId())
                .numeroLicencia(licenciaEntity.getNumeroLicencia())
                .clase(licenciaEntity.getClase())
                .fechaExpedicion(ConvertUtil.convertToLong(licenciaEntity.getFechaExpedicion()))
                .categoria(licenciaEntity.getCategoria())
                .fechaRevalidacion(ConvertUtil.convertToLong(licenciaEntity.getFechaRevalidacion()))
                .restricciones(licenciaEntity.getRestricciones())
                .cliente(
                        clienteProxyService.findByNumeroDocumento(
                                licenciaEntity.getClienteNumeroDocumento()
                        )
                )
                .clienteNumeroDocumento(licenciaEntity.getClienteNumeroDocumento())
                .build();
    }

    public LicenciaEntity mapToCreateEntity(LicenciaCreateDTO licenciaCreateDTO) {
        return LicenciaEntity.builder()
                .numeroLicencia(licenciaCreateDTO.getNumeroLicencia())
                .clase(licenciaCreateDTO.getClase())
                .fechaExpedicion(ConvertUtil.convertToLocalDate(licenciaCreateDTO.getFechaExpedicion()))
                .categoria(licenciaCreateDTO.getCategoria())
                .fechaRevalidacion(ConvertUtil.convertToLocalDate(licenciaCreateDTO.getFechaRevalidacion()))
                .restricciones(licenciaCreateDTO.getRestricciones())
                .build();
    }

    public LicenciaEntity mapToGenerateEntity(LicenciaGenerateDTO licenciaGenerateDTO) {
        return LicenciaEntity.builder()
                .numeroLicencia(licenciaGenerateDTO.getNumeroLicencia())
                .clase(licenciaGenerateDTO.getClase())
                .fechaExpedicion(ConvertUtil.convertToLocalDate(licenciaGenerateDTO.getFechaExpedicion()))
                .categoria(licenciaGenerateDTO.getCategoria())
                .fechaRevalidacion(ConvertUtil.convertToLocalDate(licenciaGenerateDTO.getFechaRevalidacion()))
                .restricciones(licenciaGenerateDTO.getRestricciones())
                .build();
    }

    public void mapToUpdate(LicenciaUpdateDTO licenciaUpdateDTO, LicenciaEntity licenciaEntity) {
        licenciaEntity.setClase(licenciaEntity.getClase());
        licenciaEntity.setFechaExpedicion(ConvertUtil.convertToLocalDate(licenciaUpdateDTO.getFechaExpedicion()));
        licenciaEntity.setCategoria(licenciaUpdateDTO.getCategoria());
        licenciaEntity.setFechaRevalidacion(ConvertUtil.convertToLocalDate(licenciaUpdateDTO.getFechaRevalidacion()));
        licenciaEntity.setRestricciones(licenciaUpdateDTO.getRestricciones());
    }
}

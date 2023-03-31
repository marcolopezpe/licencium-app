package pe.marcolopez.apps.licencium.auditoriaservice.mapper;

import org.springframework.stereotype.Component;
import pe.marcolopez.apps.licencium.auditoriaservice.data.LicenciaDocument;
import pe.marcolopez.apps.licencium.auditoriaservice.dto.LicenciaDTO;

@Component
public class LicenciaMapper {

    public LicenciaDocument toLicenciaDocument(LicenciaDTO licenciaDTO) {
        LicenciaDocument licenciaDocument = new LicenciaDocument();
        licenciaDocument.setId(licenciaDTO.getId());
        licenciaDocument.setNumeroLicencia(licenciaDTO.getNumeroLicencia());
        licenciaDocument.setClase(licenciaDTO.getClase());
        licenciaDocument.setFechaExpedicion(licenciaDTO.getFechaExpedicion());
        licenciaDocument.setCategoria(licenciaDTO.getCategoria());
        licenciaDocument.setFechaRevalidacion(licenciaDTO.getFechaRevalidacion());
        licenciaDocument.setRestricciones(licenciaDTO.getRestricciones());
        licenciaDocument.setClienteNumeroDocumento(licenciaDTO.getClienteNumeroDocumento());
        licenciaDocument.setUsuarioCreacion(licenciaDTO.getUsuarioCreacion());
        licenciaDocument.setFechaCreacion(licenciaDTO.getFechaCreacion());
        licenciaDocument.setAccion(licenciaDTO.getAccion());
        return licenciaDocument;
    }
}

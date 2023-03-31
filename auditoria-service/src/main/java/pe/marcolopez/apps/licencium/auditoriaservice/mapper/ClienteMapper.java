package pe.marcolopez.apps.licencium.auditoriaservice.mapper;

import org.springframework.stereotype.Component;
import pe.marcolopez.apps.licencium.auditoriaservice.data.ClienteDocument;
import pe.marcolopez.apps.licencium.auditoriaservice.dto.ClienteDTO;

@Component
public class ClienteMapper {

    public ClienteDocument toClienteDocument(ClienteDTO clienteDTO) {
        ClienteDocument clienteDocument = new ClienteDocument();
        clienteDocument.setId(clienteDTO.getId());
        clienteDocument.setApellidos(clienteDTO.getApellidos());
        clienteDocument.setNombres(clienteDTO.getNombres());
        clienteDocument.setNumeroDocumento(clienteDTO.getNumeroDocumento());
        clienteDocument.setFechaNacimiento(clienteDTO.getFechaNacimiento());
        clienteDocument.setDomicilio(clienteDTO.getDomicilio());
        clienteDocument.setGrupoFactorSanguineo(clienteDTO.getGrupoFactorSanguineo());
        clienteDocument.setDonacionOrganos(clienteDTO.getDonacionOrganos());
        clienteDocument.setUsuarioCreacion(clienteDTO.getUsuarioCreacion());
        clienteDocument.setFechaCreacion(clienteDTO.getFechaCreacion());
        clienteDocument.setAccion(clienteDTO.getAccion());
        return clienteDocument;
    }
}

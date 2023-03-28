package pe.marcolopez.apps.licencium.clienteservice.mapper;

import org.springframework.stereotype.Component;
import pe.marcolopez.apps.licencium.clienteservice.dto.ClienteCreateDTO;
import pe.marcolopez.apps.licencium.clienteservice.dto.ClienteDTO;
import pe.marcolopez.apps.licencium.clienteservice.dto.ClienteUpdateDTO;
import pe.marcolopez.apps.licencium.clienteservice.entity.ClienteEntity;

@Component
public class ClienteMapper {

    public ClienteDTO mapToDTO(ClienteEntity clienteEntity) {
        return ClienteDTO.builder()
                .id(clienteEntity.getId())
                .apellidos(clienteEntity.getApellidos())
                .nombres(clienteEntity.getNombres())
                .numeroDocumento(clienteEntity.getNumeroDocumento())
                .fechaNacimiento(clienteEntity.getFechaNacimiento())
                .domicilio(clienteEntity.getDomicilio())
                .grupoFactorSanguineo(clienteEntity.getGrupoFactorSanguineo())
                .donacionOrganos(clienteEntity.getDonacionOrganos())
                .build();
    }

    public ClienteEntity mapToEntity(ClienteDTO clienteDTO) {
        return ClienteEntity.builder()
                .id(clienteDTO.getId())
                .apellidos(clienteDTO.getApellidos())
                .nombres(clienteDTO.getNombres())
                .numeroDocumento(clienteDTO.getNumeroDocumento())
                .fechaNacimiento(clienteDTO.getFechaNacimiento())
                .domicilio(clienteDTO.getDomicilio())
                .grupoFactorSanguineo(clienteDTO.getGrupoFactorSanguineo())
                .donacionOrganos(clienteDTO.getDonacionOrganos())
                .build();
    }

    public ClienteEntity mapToCreateEntity(ClienteCreateDTO clienteCreateDTO) {
        return ClienteEntity.builder()
                .apellidos(clienteCreateDTO.getApellidos())
                .nombres(clienteCreateDTO.getNombres())
                .numeroDocumento(clienteCreateDTO.getNumeroDocumento())
                .fechaNacimiento(clienteCreateDTO.getFechaNacimiento())
                .domicilio(clienteCreateDTO.getDomicilio())
                .grupoFactorSanguineo(clienteCreateDTO.getGrupoFactorSanguineo())
                .donacionOrganos(clienteCreateDTO.getDonacionOrganos())
                .build();
    }

    public void mapToUpdate(ClienteUpdateDTO clienteUpdateDTO, ClienteEntity clienteEntity) {
        clienteEntity.setApellidos(clienteUpdateDTO.getApellidos());
        clienteEntity.setNombres(clienteUpdateDTO.getNombres());
        clienteEntity.setNumeroDocumento(clienteUpdateDTO.getNumeroDocumento());
        clienteEntity.setFechaNacimiento(clienteUpdateDTO.getFechaNacimiento());
        clienteEntity.setDomicilio(clienteUpdateDTO.getDomicilio());
        clienteEntity.setGrupoFactorSanguineo(clienteUpdateDTO.getGrupoFactorSanguineo());
        clienteEntity.setDonacionOrganos(clienteUpdateDTO.getDonacionOrganos());
    }
}

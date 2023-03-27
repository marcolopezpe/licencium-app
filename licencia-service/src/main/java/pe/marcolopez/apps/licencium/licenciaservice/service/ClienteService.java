package pe.marcolopez.apps.licencium.licenciaservice.service;

import pe.marcolopez.apps.licencium.licenciaservice.dto.ClienteCreateDTO;
import pe.marcolopez.apps.licencium.licenciaservice.dto.ClienteDTO;
import pe.marcolopez.apps.licencium.licenciaservice.dto.ClienteUpdateDTO;

import java.util.List;
import java.util.UUID;

public interface ClienteService {

    List<ClienteDTO> findAll();

    ClienteDTO create(ClienteCreateDTO clienteCreateDTO);

    ClienteDTO update(String numeroDocumento, ClienteUpdateDTO clienteUpdateDTO);

    void delete(UUID id);

    ClienteDTO findByNumeroDocumento(String numeroDocumento);
}

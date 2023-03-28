package pe.marcolopez.apps.licencium.clienteservice.service;

import pe.marcolopez.apps.licencium.clienteservice.dto.ClienteCreateDTO;
import pe.marcolopez.apps.licencium.clienteservice.dto.ClienteDTO;
import pe.marcolopez.apps.licencium.clienteservice.dto.ClienteUpdateDTO;

import java.util.List;
import java.util.UUID;

public interface ClienteService {

    List<ClienteDTO> findAll();

    ClienteDTO create(ClienteCreateDTO clienteCreateDTO);

    ClienteDTO update(String numeroDocumento, ClienteUpdateDTO clienteUpdateDTO);

    void delete(UUID id);

    ClienteDTO findbyId(UUID id);
    ClienteDTO findByNumeroDocumento(String numeroDocumento);
}

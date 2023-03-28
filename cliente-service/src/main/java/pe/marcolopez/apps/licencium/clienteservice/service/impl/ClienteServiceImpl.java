package pe.marcolopez.apps.licencium.clienteservice.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.marcolopez.apps.licencium.clienteservice.dto.ClienteCreateDTO;
import pe.marcolopez.apps.licencium.clienteservice.dto.ClienteDTO;
import pe.marcolopez.apps.licencium.clienteservice.dto.ClienteUpdateDTO;
import pe.marcolopez.apps.licencium.clienteservice.entity.ClienteEntity;
import pe.marcolopez.apps.licencium.clienteservice.mapper.ClienteMapper;
import pe.marcolopez.apps.licencium.clienteservice.repository.ClienteRepository;
import pe.marcolopez.apps.licencium.clienteservice.service.ClienteService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteMapper clienteMapper;
    private final ClienteRepository clienteRepository;

    @Override
    public List<ClienteDTO> findAll() {
        return clienteRepository.findAll()
                .stream()
                .map(clienteMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ClienteDTO create(ClienteCreateDTO clienteCreateDTO) {
        ClienteEntity clienteEntity = clienteMapper.mapToCreateEntity(clienteCreateDTO);
        ClienteEntity clienteSaved = clienteRepository.save(clienteEntity);
        return clienteMapper.mapToDTO(clienteSaved);
    }

    @Override
    public ClienteDTO update(String numeroDcoumento, ClienteUpdateDTO clienteUpdateDTO) {
        if (clienteRepository.findByNumeroDocumento(numeroDcoumento).isEmpty()) {
            throw new RuntimeException("El Cliente no existe!");
        }

        ClienteEntity clienteEntity = clienteRepository.findByNumeroDocumento(numeroDcoumento).get();
        clienteMapper.mapToUpdate(clienteUpdateDTO, clienteEntity);

        ClienteEntity clienteSaved = clienteRepository.save(clienteEntity);

        return clienteMapper.mapToDTO(clienteSaved);
    }

    @Override
    public void delete(UUID id) {
        Optional<ClienteEntity> clienteEntity = clienteRepository.findById(id);
        clienteEntity.ifPresent(clienteRepository::delete);
    }

    @Override
    public ClienteDTO findbyId(UUID id) {
        return clienteRepository.findById(id)
                .map(clienteMapper::mapToDTO)
                .orElse(null);
    }

    @Override
    public ClienteDTO findByNumeroDocumento(String numeroDocumento) {
        return clienteRepository.findByNumeroDocumento(numeroDocumento)
                .map(clienteMapper::mapToDTO)
                .orElse(null);
    }
}

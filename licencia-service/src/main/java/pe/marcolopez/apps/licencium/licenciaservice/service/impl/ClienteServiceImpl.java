package pe.marcolopez.apps.licencium.licenciaservice.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.marcolopez.apps.licencium.licenciaservice.dto.ClienteCreateDTO;
import pe.marcolopez.apps.licencium.licenciaservice.dto.ClienteDTO;
import pe.marcolopez.apps.licencium.licenciaservice.dto.ClienteUpdateDTO;
import pe.marcolopez.apps.licencium.licenciaservice.entity.ClienteEntity;
import pe.marcolopez.apps.licencium.licenciaservice.entity.LicenciaEntity;
import pe.marcolopez.apps.licencium.licenciaservice.mapper.ClienteMapper;
import pe.marcolopez.apps.licencium.licenciaservice.repository.ClienteRepository;
import pe.marcolopez.apps.licencium.licenciaservice.repository.LicenciaRepository;
import pe.marcolopez.apps.licencium.licenciaservice.service.ClienteService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteMapper clienteMapper;
    private final ClienteRepository clienteRepository;
    private final LicenciaRepository licenciaRepository;

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

        if (clienteEntity.isPresent()) {
            LicenciaEntity licenciaEntity = licenciaRepository.validate(clienteEntity.get().getNumeroDocumento());

            if (licenciaEntity != null) {
                throw new RuntimeException("No se puede eliminar el Cliente, porque tiene Licencia relacionada.");
            }

            clienteRepository.delete(clienteEntity.get());
        }
    }

    @Override
    public ClienteDTO findByNumeroDocumento(String numeroDocumento) {
        return clienteRepository.findByNumeroDocumento(numeroDocumento)
                .map(clienteMapper::mapToDTO)
                .orElse(null);
    }
}

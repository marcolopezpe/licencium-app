package pe.marcolopez.apps.licencium.licenciaservice.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.marcolopez.apps.licencium.licenciaservice.dto.*;
import pe.marcolopez.apps.licencium.licenciaservice.entity.LicenciaEntity;
import pe.marcolopez.apps.licencium.licenciaservice.mapper.LicenciaMapper;
import pe.marcolopez.apps.licencium.licenciaservice.repository.LicenciaRepository;
import pe.marcolopez.apps.licencium.licenciaservice.service.ClienteProxyService;
import pe.marcolopez.apps.licencium.licenciaservice.service.LicenciaService;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LicenciaServiceImpl implements LicenciaService {

    private final LicenciaMapper licenciaMapper;
    private final LicenciaRepository licenciaRepository;
    private final ClienteProxyService clienteProxyService;

    @Override
    public List<LicenciaDTO> findAll() {
        return licenciaRepository.findAll()
                .stream()
                .map(licenciaMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<LicenciaDTO> findAllByFilters(String numeroDocumento, String categoria, String numero) {
        return licenciaRepository.findAllByFilters(numeroDocumento, categoria, numero)
                .stream()
                .map(licenciaMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LicenciaDTO create(LicenciaCreateDTO licenciaCreateDTO) {
        if (clienteProxyService.findByNumeroDocumento(licenciaCreateDTO.getClienteNumeroDocumento()) == null) {
            throw new RuntimeException("El Cliente no existe!");
        }

        LicenciaEntity licenciaEntity = licenciaMapper.mapToCreateEntity(licenciaCreateDTO);
        licenciaEntity.setClienteNumeroDocumento(licenciaCreateDTO.getClienteNumeroDocumento());

        LicenciaEntity licenciaSaved = licenciaRepository.save(licenciaEntity);

        return licenciaMapper.mapToDTO(licenciaSaved);
    }

    @Override
    public LicenciaDTO update(LicenciaUpdateDTO licenciaUpdateDTO) {
        if (licenciaRepository.findById(licenciaUpdateDTO.getId()).isEmpty()) {
            throw new RuntimeException("La Licencia no existe!");
        }

        LicenciaEntity licenciaEntity = licenciaRepository.findById(licenciaUpdateDTO.getId()).get();
        licenciaMapper.mapToUpdate(licenciaUpdateDTO, licenciaEntity);

        LicenciaEntity licenciaUpdated = licenciaRepository.save(licenciaEntity);

        return licenciaMapper.mapToDTO(licenciaUpdated);
    }

    @Override
    public void delete(UUID id) {
        licenciaRepository.deleteById(id);
    }

    @Override
    public LicenciaDTO generate(LicenciaGenerateDTO licenciaGenerateDTO) {
        if (clienteProxyService.findByNumeroDocumento(licenciaGenerateDTO.getNumeroDocumento()) == null) {
            throw new RuntimeException("El Cliente con Documento %s no existe!".formatted(licenciaGenerateDTO.getNumeroDocumento()));
        }

        LicenciaEntity licenciaEntity = licenciaMapper.mapToGenerateEntity(licenciaGenerateDTO);
        licenciaEntity.setClienteNumeroDocumento(licenciaEntity.getClienteNumeroDocumento());

        LicenciaEntity licenciaSaved = licenciaRepository.save(licenciaEntity);

        return licenciaMapper.mapToDTO(licenciaSaved);
    }

    @Override
    public LicenciaDTO validate(String numeroDocumento) {
        return licenciaMapper.mapToDTO(
                licenciaRepository.validate(numeroDocumento)
        );
    }

    @Override
    public LicenciaDTO findByNumeroLicencia(String numeroLicencia) {
        return licenciaMapper.mapToDTO(
                licenciaRepository.findByNumeroLicencia(numeroLicencia)
        );
    }

    @Override
    public LicenciaDTO findById(UUID id) {
        return licenciaMapper.mapToDTO(
                Objects.requireNonNull(licenciaRepository.findById(id).orElse(null))
        );
    }
}

package pe.marcolopez.apps.licencium.licenciaservice.service;

import pe.marcolopez.apps.licencium.licenciaservice.dto.LicenciaCreateDTO;
import pe.marcolopez.apps.licencium.licenciaservice.dto.LicenciaDTO;
import pe.marcolopez.apps.licencium.licenciaservice.dto.LicenciaGenerateDTO;
import pe.marcolopez.apps.licencium.licenciaservice.dto.LicenciaUpdateDTO;

import java.util.List;
import java.util.UUID;

public interface LicenciaService {

    List<LicenciaDTO> findAll();

    List<LicenciaDTO> findAllByFilters(String numeroDocumento, String categoria, String numero);

    LicenciaDTO create(LicenciaCreateDTO licenciaCreateDTO);

    LicenciaDTO update(LicenciaUpdateDTO licenciaUpdateDTO);

    void delete(UUID id);

    LicenciaDTO generate(LicenciaGenerateDTO licenciaGenerateDTO);

    LicenciaDTO validate(String numeroDocumento);

    LicenciaDTO findByNumeroLicencia(String numeroLicencia);

    LicenciaDTO findById(UUID id);
}

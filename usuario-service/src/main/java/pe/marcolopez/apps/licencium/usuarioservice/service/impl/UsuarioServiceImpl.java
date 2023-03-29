package pe.marcolopez.apps.licencium.usuarioservice.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.marcolopez.apps.licencium.usuarioservice.dto.UsuarioCreateDTO;
import pe.marcolopez.apps.licencium.usuarioservice.dto.UsuarioDTO;
import pe.marcolopez.apps.licencium.usuarioservice.dto.UsuarioUpdateDTO;
import pe.marcolopez.apps.licencium.usuarioservice.entity.UsuarioEntity;
import pe.marcolopez.apps.licencium.usuarioservice.kafka.UsuarioProducer;
import pe.marcolopez.apps.licencium.usuarioservice.mapper.UsuarioMapper;
import pe.marcolopez.apps.licencium.usuarioservice.repository.UsuarioRepository;
import pe.marcolopez.apps.licencium.usuarioservice.service.UsuarioService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioMapper usuarioMapper;
    private final UsuarioRepository usuarioRepository;
    private final UsuarioProducer usuarioProducer;

    @Override
    public UsuarioDTO create(UsuarioCreateDTO usuarioCreateDTO) {
        UsuarioEntity usuarioEntity = usuarioMapper.mapToEntity(usuarioCreateDTO);
        UsuarioEntity usuarioSaved = usuarioRepository.save(usuarioEntity);
        usuarioProducer.send(usuarioCreateDTO, usuarioSaved.getId());
        return usuarioMapper.mapToDTO(usuarioSaved);
    }

    @Override
    public UsuarioDTO update(UUID id, UsuarioUpdateDTO usuarioUpdateDTO) {
        if (usuarioRepository.findById(id).isPresent()) {
            UsuarioEntity usuarioEntity = usuarioRepository.findById(id).get();
            usuarioMapper.mapToUpdate(usuarioUpdateDTO, usuarioEntity);
            return usuarioMapper.mapToDTO(
                    usuarioRepository.save(usuarioEntity)
            );
        }
        return null;
    }

    @Override
    public void delete(UUID id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public UsuarioDTO findByEmail(String email) {
        return usuarioMapper.mapToDTO(
                usuarioRepository.findByEmail(email)
        );
    }

    @Override
    public List<UsuarioDTO> findAll() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuarioMapper::mapToDTO)
                .collect(Collectors.toList());
    }
}

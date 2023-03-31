package pe.marcolopez.apps.licencium.usuarioservice.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.marcolopez.apps.licencium.usuarioservice.dto.UsuarioCreateDTO;
import pe.marcolopez.apps.licencium.usuarioservice.dto.UsuarioDTO;
import pe.marcolopez.apps.licencium.usuarioservice.dto.UsuarioUpdateDTO;
import pe.marcolopez.apps.licencium.usuarioservice.entity.UsuarioEntity;
import pe.marcolopez.apps.licencium.usuarioservice.mapper.UsuarioMapper;
import pe.marcolopez.apps.licencium.usuarioservice.repository.UsuarioRepository;
import pe.marcolopez.apps.licencium.usuarioservice.service.UsuarioService;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioMapper usuarioMapper;
    private final UsuarioRepository usuarioRepository;

    @Override
    public UsuarioDTO create(UsuarioCreateDTO usuarioCreateDTO) {
        UsuarioEntity usuarioEntity = usuarioMapper.mapToEntity(usuarioCreateDTO);
        UsuarioEntity usuarioSaved = usuarioRepository.save(usuarioEntity);
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
    public UsuarioDTO findById(UUID id) {
        return usuarioMapper.mapToDTO(
                Objects.requireNonNull(usuarioRepository.findById(id).orElse(null))
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

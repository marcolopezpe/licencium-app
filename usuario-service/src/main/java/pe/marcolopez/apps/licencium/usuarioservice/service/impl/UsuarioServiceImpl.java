package pe.marcolopez.apps.licencium.usuarioservice.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.marcolopez.apps.licencium.usuarioservice.dto.UsuarioDTO;
import pe.marcolopez.apps.licencium.usuarioservice.mapper.UsuarioMapper;
import pe.marcolopez.apps.licencium.usuarioservice.repository.UsuarioRepository;
import pe.marcolopez.apps.licencium.usuarioservice.service.UsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioMapper usuarioMapper;
    private final UsuarioRepository usuarioRepository;

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

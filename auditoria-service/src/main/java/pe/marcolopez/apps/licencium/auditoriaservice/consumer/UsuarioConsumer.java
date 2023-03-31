package pe.marcolopez.apps.licencium.auditoriaservice.consumer;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import pe.marcolopez.apps.licencium.auditoriaservice.dto.UsuarioDTO;
import pe.marcolopez.apps.licencium.auditoriaservice.mapper.UsuarioMapper;
import pe.marcolopez.apps.licencium.auditoriaservice.repository.UsuarioRepository;

@Slf4j
@Service
@AllArgsConstructor
public class UsuarioConsumer {

    private final Gson gson;
    private final UsuarioMapper usuarioMapper;
    private final UsuarioRepository usuarioRepository;

    @KafkaListener(topics = "${kafka.topic.usuarios:usuarios}", groupId = "usuarios-audit")
    public void consumeUsuarios(String json) {
        log.info("### -> Consuming message with payload JSON: {}", json);

        UsuarioDTO usuarioDTO = gson.fromJson(json, UsuarioDTO.class);
        log.info("### -> Consuming message with payload: {}", usuarioDTO.toString());

        usuarioRepository.save(usuarioMapper.toUsuarioDocument(usuarioDTO));
    }
}

package pe.marcolopez.apps.licencium.usuarioservice.producer;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import pe.marcolopez.apps.licencium.usuarioservice.dto.UsuarioDTO;

@Slf4j
@Service
@RequiredArgsConstructor
public class UsuarioProducer {

    @Value("${kafka.topic:usuarios}")
    private String topicName;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final Gson gson;

    public void send(UsuarioDTO usuarioDTO) {
        usuarioDTO.setUsuarioCreacion("SYSTEM");
        usuarioDTO.setFechaCreacion(System.currentTimeMillis());

        String json = gson.toJson(usuarioDTO);

        log.info("### -> Sending message to topic: {} with payload: {}", topicName, usuarioDTO);
        log.info("### -> Sending message to topic: {} with payload JSON: {}", topicName, json);

        kafkaTemplate.send(topicName, usuarioDTO.getNombreUsuario(), json);
    }
}

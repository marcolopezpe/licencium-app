package pe.marcolopez.apps.licencium.usuarioservice.kafka;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import pe.marcolopez.apps.licencium.usuarioservice.dto.UsuarioCreateDTO;

import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class UsuarioProducer {

    private final NewTopic topic;
    private final KafkaTemplate<String, UsuarioCreateDTO> kafkaTemplate;

    public void send(UsuarioCreateDTO usuarioCreateDTO) {
        log.info("### -> Sending message to topic: {} with payload: {}", topic.name(), usuarioCreateDTO);

        kafkaTemplate.send(
                topic.name(),
                usuarioCreateDTO.getNombreUsuario(),
                usuarioCreateDTO
        );
    }
}

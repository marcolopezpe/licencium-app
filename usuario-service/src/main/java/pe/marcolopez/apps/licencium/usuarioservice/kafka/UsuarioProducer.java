package pe.marcolopez.apps.licencium.usuarioservice.kafka;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import pe.marcolopez.apps.licencium.usuarioservice.dto.UsuarioCreateDTO;

import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class UsuarioProducer {

    @Value("${kafka.topic:usuarios}")
    private final String topicName;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final Gson gson;

    public void send(UsuarioCreateDTO usuarioCreateDTO) {
        String json = gson.toJson(usuarioCreateDTO);

        log.info("### -> Sending message to topic: {} with payload: {}", topicName, usuarioCreateDTO.toString());
        log.info("### -> Sending message to topic: {} with payload JSON: {}", topicName, json);

        Message<String> message = MessageBuilder
                .withPayload(json)
                .setHeader(KafkaHeaders.TOPIC, topicName)
                .setHeader(KafkaHeaders.KEY, usuarioCreateDTO.getNombreUsuario())
                .build();

        kafkaTemplate.send(message);

        /*kafkaTemplate.send(
                topic.name(),
                usuarioCreateDTO.getNombreUsuario(),
                usuarioCreateDTO
        );*/
    }
}

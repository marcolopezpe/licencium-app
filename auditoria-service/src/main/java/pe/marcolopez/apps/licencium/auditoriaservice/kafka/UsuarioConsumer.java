package pe.marcolopez.apps.licencium.auditoriaservice.kafka;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import pe.marcolopez.apps.licencium.auditoriaservice.dto.UsuarioCreateDTO;

@Slf4j
@Service
@AllArgsConstructor
public class UsuarioConsumer {

    private final Gson gson;

    @KafkaListener(
            topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(String json) {
        UsuarioCreateDTO usuarioCreateDTO = gson.fromJson(json, UsuarioCreateDTO.class);
        log.info("### -> Consuming message with payload: {}", usuarioCreateDTO.toString());

        // Save UsuarioCreateDTO on mongodb
    }
}
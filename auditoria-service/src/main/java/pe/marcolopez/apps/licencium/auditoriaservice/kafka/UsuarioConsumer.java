package pe.marcolopez.apps.licencium.auditoriaservice.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import pe.marcolopez.apps.licencium.auditoriaservice.dto.UsuarioCreateDTO;

@Slf4j
@Service
public class UsuarioConsumer {

    @KafkaListener(
            topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(UsuarioCreateDTO usuarioCreateDTO) {
        log.info("### -> Consuming message with payload: {}", usuarioCreateDTO);

        // Save UsuarioCreateDTO on mongodb
    }
}

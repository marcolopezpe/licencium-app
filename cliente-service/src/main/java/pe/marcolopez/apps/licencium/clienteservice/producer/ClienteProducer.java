package pe.marcolopez.apps.licencium.clienteservice.producer;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import pe.marcolopez.apps.licencium.clienteservice.dto.ClienteDTO;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClienteProducer {

    @Value("${kafka.topic:licencias}")
    private String topicName;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final Gson gson;

    public void send(ClienteDTO clienteDTO) {
        clienteDTO.setUsuarioCreacion("SYSTEM");
        clienteDTO.setFechaCreacion(System.currentTimeMillis());

        String json = gson.toJson(clienteDTO);

        log.info("### -> Sending message to topic: {} with payload: {}", topicName, clienteDTO);
        log.info("### -> Sending message to topic: {} with payload JSON: {}", topicName, json);

        kafkaTemplate.send(topicName, clienteDTO.getNumeroDocumento(), json);
    }
}

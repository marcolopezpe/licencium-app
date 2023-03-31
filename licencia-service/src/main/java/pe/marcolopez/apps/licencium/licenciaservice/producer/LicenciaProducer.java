package pe.marcolopez.apps.licencium.licenciaservice.producer;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import pe.marcolopez.apps.licencium.licenciaservice.dto.LicenciaDTO;

@Slf4j
@Service
@RequiredArgsConstructor
public class LicenciaProducer {

    @Value("${kafka.topic:licencias}")
    private String topicName;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final Gson gson;

    public void send(LicenciaDTO licenciaDTO) {
        licenciaDTO.setUsuarioCreacion("SYSTEM");
        licenciaDTO.setFechaCreacion(System.currentTimeMillis());

        String json = gson.toJson(licenciaDTO);

        log.info("### -> Sending message to topic: {} with payload: {}", topicName, licenciaDTO);
        log.info("### -> Sending message to topic: {} with payload JSON: {}", topicName, json);

        kafkaTemplate.send(topicName, licenciaDTO.getNumeroLicencia(), json);
    }
}

package pe.marcolopez.apps.licencium.auditoriaservice.consumer;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import pe.marcolopez.apps.licencium.auditoriaservice.dto.LicenciaDTO;
import pe.marcolopez.apps.licencium.auditoriaservice.mapper.LicenciaMapper;
import pe.marcolopez.apps.licencium.auditoriaservice.repository.LicenciaRepository;

@Slf4j
@Service
@AllArgsConstructor
public class LicenciaConsumer {

    private final Gson gson;
    private final LicenciaMapper licenciaMapper;
    private final LicenciaRepository licenciaRepository;

    @KafkaListener(topics = "${kafka.topic.licencias:licencias}", groupId = "licencias-audit")
    public void consumeLicencias(String json) {
        log.info("### -> Consuming message with payload JSON: {}", json);

        LicenciaDTO licenciaDTO = gson.fromJson(json, LicenciaDTO.class);
        log.info("### -> Consuming message with payload: {}", licenciaDTO.toString());

        licenciaRepository.save(licenciaMapper.toLicenciaDocument(licenciaDTO));
    }
}

package pe.marcolopez.apps.licencium.auditoriaservice.consumer;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import pe.marcolopez.apps.licencium.auditoriaservice.dto.ClienteDTO;
import pe.marcolopez.apps.licencium.auditoriaservice.mapper.ClienteMapper;
import pe.marcolopez.apps.licencium.auditoriaservice.repository.ClienteRepository;

@Slf4j
@Service
@AllArgsConstructor
public class ClienteConsumer {

    private final Gson gson;
    private final ClienteMapper clienteMapper;
    private final ClienteRepository clienteRepository;

    @KafkaListener(topics = "${kafka.topic.clientes:clientes}", groupId = "clientes-audit")
    public void consumeClientes(String json) {
        log.info("### -> Consuming message with payload JSON: {}", json);

        ClienteDTO clienteDTO = gson.fromJson(json, ClienteDTO.class);
        log.info("### -> Consuming message with payload: {}", clienteDTO.toString());

        clienteRepository.save(clienteMapper.toClienteDocument(clienteDTO));
    }
}

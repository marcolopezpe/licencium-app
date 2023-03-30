package pe.marcolopez.apps.licencium.usuarioservice.config;

import com.google.gson.Gson;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {

    @Value("${kafka.server:localhost}")
    private String kafkaServer;

    @Value("${kafka.port:29092}")
    private String kafkaPort;

    public ProducerFactory<String, String> producerFactory() {
        Map<String, Object> kafkaProperties = new HashMap<>();
        kafkaProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServer + ":" + kafkaPort);
        kafkaProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        kafkaProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return new DefaultKafkaProducerFactory<>(kafkaProperties);
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    @Bean
    public Gson gson() {
        return new Gson();
    }
}

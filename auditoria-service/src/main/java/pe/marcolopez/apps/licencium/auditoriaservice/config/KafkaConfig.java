package pe.marcolopez.apps.licencium.auditoriaservice.config;

import com.google.gson.Gson;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic topic() {
        return TopicBuilder
                .name("usuario_topics")
                .partitions(3)
                .replicas(1)
                .build();
    }

    @Bean
    public Gson gson() {
        return new Gson();
    }
}

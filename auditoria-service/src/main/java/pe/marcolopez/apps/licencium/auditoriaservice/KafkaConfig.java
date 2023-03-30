package pe.marcolopez.apps.licencium.auditoriaservice;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

    @Bean
    public Gson gson() {
        return new Gson();
    }
}

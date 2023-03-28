package pe.marcolopez.apps.licencium.licenciaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LicenciaServiceApplication {

	public static void main(String... args) {
		SpringApplication.run(LicenciaServiceApplication.class, args);
	}

}

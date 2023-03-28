package pe.marcolopez.apps.licencium.licenciaservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pe.marcolopez.apps.licencium.licenciaservice.dto.ClienteDTO;

@FeignClient(name = "cliente-service")
public interface ClienteProxyService {

    @GetMapping("/numero-documento/{numeroDocumento}")
    ClienteDTO findByNumeroDocumento(@PathVariable String numeroDocumento);
}

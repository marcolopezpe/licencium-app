package pe.marcolopez.apps.licencium.clienteservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pe.marcolopez.apps.licencium.clienteservice.dto.LicenciaDTO;

@FeignClient(name = "licencia-service")
public interface LicenciaProxyService {

    @GetMapping("/numero-documento/{numeroDocumento}")
    LicenciaDTO validate(@PathVariable String numeroDocumento);
}

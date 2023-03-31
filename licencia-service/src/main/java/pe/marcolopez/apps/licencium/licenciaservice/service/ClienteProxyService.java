package pe.marcolopez.apps.licencium.licenciaservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pe.marcolopez.apps.licencium.licenciaservice.dto.ClienteDTO;

@FeignClient(name = "cliente-service", fallback = ClienteProxyService.FallBack.class)
public interface ClienteProxyService {

    @GetMapping("/clientes/numero-documento/{numeroDocumento}")
    ClienteDTO findByNumeroDocumento(@PathVariable String numeroDocumento);

    @Slf4j
    @Component
    class FallBack implements ClienteProxyService {

        @Override
        public ClienteDTO findByNumeroDocumento(String numeroDocumento) {
            log.error("No se pudo obtener el cliente con numero de documento: {}", numeroDocumento);

            return ClienteDTO.builder()
                    .id(null)
                    .apellidos("No se pudo obtener el cliente")
                    .nombres("No se pudo obtener el cliente")
                    .numeroDocumento("No se pudo obtener el cliente")
                    .fechaNacimiento(null)
                    .domicilio("No se pudo obtener el cliente")
                    .grupoFactorSanguineo("No se pudo obtener el cliente")
                    .donacionOrganos(false)
                    .build();
        }
    }
}

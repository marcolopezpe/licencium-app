package pe.marcolopez.apps.licencium.apigateway.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import pe.marcolopez.apps.licencium.apigateway.filters.JwtAuthenticationFilter;

@Configuration
@EnableWebFluxSecurity
@AllArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter authenticationFilter;

    @Bean
    public SecurityWebFilterChain configure(ServerHttpSecurity http) {
        http
                .authorizeExchange()
                // oauth server
                .pathMatchers(HttpMethod.GET, "/api/security/oauth/**").permitAll()
                // usuario service
                .pathMatchers(HttpMethod.GET, "/api/usuarios/**").authenticated()
                // licencia service
                .pathMatchers(HttpMethod.GET, "/api/licencias/**").authenticated()
                // others
                .pathMatchers( "/actuator/**").permitAll()
                .anyExchange().authenticated()
                .and()
                .addFilterAt(authenticationFilter, SecurityWebFiltersOrder.AUTHENTICATION)
                .csrf(ServerHttpSecurity.CsrfSpec::disable);

        return http.build();
    }
}

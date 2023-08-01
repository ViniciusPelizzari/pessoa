/**
 * @author Vinícius Pelizzari
 * @version 1.0
 */
package com.firstproject.projectbf.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//Classe responsável por configurar compartilhamento de dados
@Configuration
public class WebConfig {

    @Value("${cors.origins}")
    private String corsOrigins;

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        /**
         * Configura o CORS (Compartilhamento de Recursos entre Origens) para a aplicação.
         * Este método adiciona mapeamentos de CORS para permitir solicitações de origens especificadas.
         *
         * @param registry O CorsRegistry ao qual os mapeamentos de CORS serão adicionados.
         * @see CorsRegistry
         */
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods("*").allowedOrigins(corsOrigins);
            }
        };
    }

}

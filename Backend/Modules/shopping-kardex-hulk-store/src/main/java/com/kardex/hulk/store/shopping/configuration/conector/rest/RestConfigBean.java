package com.kardex.hulk.store.shopping.configuration.conector.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestConfigBean {

    @Bean("restConnectorIntegrator")
    public RestConnector getRestConnector() {
        return new RestConnector();
    }
}

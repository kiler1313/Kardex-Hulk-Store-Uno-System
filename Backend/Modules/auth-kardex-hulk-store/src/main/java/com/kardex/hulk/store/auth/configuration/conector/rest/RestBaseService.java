package com.kardex.hulk.store.auth.configuration.conector.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class RestBaseService {
    @Autowired
    @Qualifier("restConnectorIntegrator")
    private RestConnector client;

    protected RestConnector getClient() {
        return client;
    }

}

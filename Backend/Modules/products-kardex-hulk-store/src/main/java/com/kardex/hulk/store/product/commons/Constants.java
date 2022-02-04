package com.kardex.hulk.store.product.commons;

import java.io.Serializable;

public class Constants  implements Serializable {

    private Constants() {
        super();
    }

    // Yml properties
    public static final String PROJECT_PATH = "${spring.application.root}";
    public static final String PING_YML_ROUTE = "${spring.application.services.rest.ping.path}";
    public static final String SPRING_CONFIG_PREFIX = "spring.application";

    //Util
    public static final String LOG_LINE = "------------------------------------------------";
    public static final String AUTHORIZATION_HEADER = "Authorization";
    // Logs on start application
    public static final String LOG_START_PROJECT = "{} Aplicación iniciada";
    public static final String LOG_PORT_OF_PROJECT = "Puerto: {}";
    public static final String LOG_PROJECT_VERSION = "Versión: {}";
    public static final String LOG_RUN_OK = "Lanzamiento [OK]";

    //Correlative
    static final String CORRELATIVE_ID = "correlation-id";
    static final String COMPONENT_CORRELATIVE = "component";


    //Validator fields Regex
    public static final String REGEXP_NUMERIC = "[0-9]+";

    public static final String AUTHORIZATION_HEADER_X_API_KEY = "x-api-key";
    public static final String AUTHORIZATION_HEADER_TOKEN = "Authorization";
    public static final String TOKEN = "Token";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String HOST = "Host";

    //Status To Products
    public static final Integer ACTIVED = 1;
    public static final Integer OUT_OF_STOCK = 2;
    public static final Integer DESACTIVATED = 3;
    public static final Integer ZERO = 0;


    //Values Specials
    public static final String ENCRYPTED_PASSWORD = "{spring.datasource.mysql.encrypted.root}";
}

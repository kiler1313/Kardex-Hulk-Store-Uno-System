package com.kardex.hulk.store.shopping.commons;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "spring.application")
public class GlobalProperties {

    private static final long serialVersionUID = -3395163916611319213L;

    private String name;

    private String version;

    private int port;
}

package com.kardex.hulk.store.product;

import com.kardex.hulk.store.product.commons.Constants;
import com.kardex.hulk.store.product.commons.GlobalProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import javax.validation.constraints.NotNull;

@Slf4j
@EnableConfigurationProperties({
		GlobalProperties.class
})
@SpringBootApplication
public class ProductApplication implements ApplicationListener<ContextRefreshedEvent> {

	private final GlobalProperties globalProperties;

	public ProductApplication(GlobalProperties pGlobalProperties) {
		this.globalProperties = pGlobalProperties;
	}

	public static void main(String[] args) {SpringApplication.run(ProductApplication.class, args);}

	public void onApplicationEvent( ContextRefreshedEvent event) {
		log.info(Constants.LOG_LINE);
		log.info(Constants.LOG_START_PROJECT, globalProperties.getName());
		log.info(Constants.LOG_PORT_OF_PROJECT, globalProperties.getPort());
		log.info(Constants.LOG_PROJECT_VERSION, globalProperties.getVersion());
		log.info(Constants.LOG_RUN_OK);
		log.info(Constants.LOG_LINE);
	}

}

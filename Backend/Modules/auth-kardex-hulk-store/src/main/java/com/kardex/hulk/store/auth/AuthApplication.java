package com.kardex.hulk.store.auth;

import com.kardex.hulk.store.auth.commons.Constants;
import com.kardex.hulk.store.auth.commons.GlobalProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

@Slf4j
@EnableConfigurationProperties({
		GlobalProperties.class
})
@SpringBootApplication
public class AuthApplication implements ApplicationListener<ContextRefreshedEvent> {

	private final GlobalProperties globalProperties;

	public AuthApplication(GlobalProperties pGlobalProperties) {
		this.globalProperties = pGlobalProperties;
	}

	public static void main(String[] args) {SpringApplication.run(AuthApplication.class, args);}

	public void onApplicationEvent( ContextRefreshedEvent event) {
		log.info(Constants.LOG_LINE);
		log.info(Constants.LOG_START_PROJECT, globalProperties.getName());
		log.info(Constants.LOG_PORT_OF_PROJECT, globalProperties.getPort());
		log.info(Constants.LOG_PROJECT_VERSION, globalProperties.getVersion());
		log.info(Constants.LOG_RUN_OK);
		log.info(Constants.LOG_LINE);
	}

}

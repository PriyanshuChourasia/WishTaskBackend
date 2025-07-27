package com.wish.WishTaskManagement.TaskManagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskManagementApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(TaskManagementApplication.class);

	@Value("${spring.app.URL}")
	private String appURL;

	@Value("${spring.swagger.URL}")
	private String swaggerURL;

	@Value("${spring.swagger.openAPIjson}")
	private String OpenAPIJSON;

	public static void main(String[] args) {
		SpringApplication.run(TaskManagementApplication.class, args);
	}

	@Override
	public void run(final String... args){
		logger.info("Application URL: {}",appURL);
		logger.info("Swagger URL: {}",swaggerURL);
		logger.info("JSON Docs: {}",OpenAPIJSON);
	}

}

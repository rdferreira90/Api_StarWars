package com.rodrigo.starwars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class DesafioStarWarsApplication  extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DesafioStarWarsApplication.class);
	}
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(DesafioStarWarsApplication.class, args);
				
	}
	
}

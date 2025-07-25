package com.code.music_catalog_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.code.music_catalog_service", "com.code.common_vo"})
public class MusicCatalogServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicCatalogServiceApplication.class, args);
	}	
}

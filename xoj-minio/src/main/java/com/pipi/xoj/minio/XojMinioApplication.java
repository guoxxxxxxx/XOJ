package com.pipi.xoj.minio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class XojMinioApplication {

	public static void main(String[] args) {
		SpringApplication.run(XojMinioApplication.class, args);
	}

}

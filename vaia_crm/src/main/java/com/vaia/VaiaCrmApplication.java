package com.vaia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class VaiaCrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(VaiaCrmApplication.class, args);
	}
}

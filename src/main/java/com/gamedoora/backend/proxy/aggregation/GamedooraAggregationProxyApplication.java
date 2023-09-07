package com.gamedoora.backend.proxy.aggregation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GamedooraAggregationProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(GamedooraAggregationProxyApplication.class, args);
	}

}

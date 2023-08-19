package com.gamedoora.backend.proxy.aggregation.config;

import com.gamedoora.backend.proxy.aggregation.exceptions.FeignCustomErrorDecoder;
import feign.Logger;
import feign.Retryer;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {
    @Bean
    Logger.Level loggerLevel(){
        return Logger.Level.FULL;
    }
    @Bean
    public ErrorDecoder errorDecoder(){
        return new FeignCustomErrorDecoder();
    }
    @Bean
    public Retryer retryer() {
        return new Retryer.Default(100, 2000, 3);
    }
}

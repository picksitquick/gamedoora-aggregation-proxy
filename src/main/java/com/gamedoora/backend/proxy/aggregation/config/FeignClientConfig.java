package com.gamedoora.backend.proxy.aggregation.config;

import feign.Logger;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {
    Logger.Level loggerLevel(){
        return Logger.Level.FULL;
    }
}

package com.gamedoora.backend.proxy.aggregation.routes;

import com.gamedoora.backend.proxy.aggregation.enrichment.clients.RetriableStudiosServicesClient;
import feign.FeignException;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class StudioProfileRoute extends RouteBuilder {

    private RetriableStudiosServicesClient studiosServicesClient;

    @Override
    public void configure() throws Exception{
        onException(FeignException.class)
                .maximumRedeliveries(3)
                .logStackTrace(true)
                .handled(false);

        from("direct:studioQuery")
                .to("bean:retriableStudiosServicesClient?method=getStudioForUserByEmail")
                .end();
    }
}

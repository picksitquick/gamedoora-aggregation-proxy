package com.gamedoora.backend.proxy.aggregation.routes;

import com.gamedoora.backend.proxy.aggregation.enrichment.clients.RetriableRolesServicesClient;
import com.gamedoora.backend.proxy.aggregation.enrichment.clients.RetriableSkillsServicesClient;
import com.gamedoora.backend.proxy.aggregation.enrichment.clients.RetriableUsersServicesClient;
import com.gamedoora.backend.proxy.aggregation.exceptions.ClientResponseException;
import feign.FeignException;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.processor.aggregate.GroupedExchangeAggregationStrategy;
import org.apache.camel.processor.aggregate.GroupedMessageAggregationStrategy;
import org.springframework.stereotype.Component;

@Component
public class UserProfileRoute extends RouteBuilder {
    private RetriableRolesServicesClient retriableRolesServicesClient;
    private RetriableSkillsServicesClient retriableSkillsServicesClient;
    private RetriableUsersServicesClient retriableUsersServicesClient;

    @Override
    public void configure() throws Exception {
        onException(FeignException.class)
                .maximumRedeliveries(3)
                .logStackTrace(true)
                .handled(false);
        from("direct:userProfileQuery")
                .multicast(new GroupedMessageAggregationStrategy()).parallelProcessing()
                .stopOnException()
                .to("bean:retriableRolesServicesClient?method=getRolesForUserByEmail")
                .to("bean:retriableSkillsServicesClient?method=getSkillsForUserByEmail")
                .to("bean:retriableUsersServicesClient?method=getRolesForUserByEmail")
                .end();

    }


}

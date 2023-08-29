package com.gamedoora.backend.proxy.aggregation.assembler;

import com.gamedoora.backend.proxy.aggregation.routes.UserProfileRoute;
import com.gamedoora.model.dto.GdUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.support.DefaultExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class UserDataAggregatorAssembler {
    private ProducerTemplate producerTemplate;

    @Autowired
    private CamelContext camelContext;
    private UserProfileRoute userProfileRoute;
    public GdUser getUserByEmail(String email){
        Exchange exchange = new DefaultExchange(camelContext);
        exchange.getIn().setBody(email);
        Exchange result =  getProducerTemplate().send("direct:userProfileQuery", exchange);

        return null;
    }

    public ProducerTemplate getProducerTemplate() {
        return producerTemplate;
    }
    @Autowired
    public void setProducerTemplate(ProducerTemplate producerTemplate) {
        this.producerTemplate = producerTemplate;
    }
}

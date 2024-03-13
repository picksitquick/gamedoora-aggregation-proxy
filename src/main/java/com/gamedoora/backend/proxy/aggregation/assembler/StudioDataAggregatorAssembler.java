package com.gamedoora.backend.proxy.aggregation.assembler;

import com.gamedoora.backend.proxy.aggregation.routes.StudioProfileRoute;
import com.gamedoora.model.dto.GdUser;
import com.gamedoora.model.dto.StudiosDTO;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudioDataAggregatorAssembler {
    private ProducerTemplate producerTemplate;

    @Autowired
    private CamelContext camelContext;
    private StudioProfileRoute studioProfileRoute;

    public GdUser getStudiosByUser(String email){
        List<StudiosDTO> studioDTOList = getProducerTemplate().requestBody("direct:studioUserQuery" , email, ArrayList.class);
        return GdUser
                .builder()
                .studios(studioDTOList)
                .build();
    }

    public ProducerTemplate getProducerTemplate() {
        return producerTemplate;
    }

    public void setProducerTemplate(ProducerTemplate producerTemplate) {
        this.producerTemplate = producerTemplate;
    }
}

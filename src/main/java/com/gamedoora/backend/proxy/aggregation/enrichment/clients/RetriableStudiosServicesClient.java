package com.gamedoora.backend.proxy.aggregation.enrichment.clients;

import com.gamedoora.model.dto.StudiosDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RetriableStudiosServicesClient {

    private StudioServicesClient studioServicesClient;

    private RetryTemplate retryTemplate;

    public List<StudiosDTO> getStudiosForUserByEmail(String email){
        return getRetryTemplate().execute(retryContext -> getStudioServicesClient().getStudiosByUser(email));
    }

    public StudioServicesClient getStudioServicesClient() {
        return studioServicesClient;
    }

    @Autowired
    public void setStudioServicesClient(StudioServicesClient studioServicesClient) {
        this.studioServicesClient = studioServicesClient;
    }

    public RetryTemplate getRetryTemplate() {
        return retryTemplate;
    }

    @Autowired
    public void setRetryTemplate(RetryTemplate retryTemplate) {
        this.retryTemplate = retryTemplate;
    }
}

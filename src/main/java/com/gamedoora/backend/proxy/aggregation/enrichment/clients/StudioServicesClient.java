package com.gamedoora.backend.proxy.aggregation.enrichment.clients;

import com.gamedoora.backend.proxy.aggregation.enrichment.apis.StudioServicesApi;
import com.gamedoora.model.dto.StudiosDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudioServicesClient {

    private StudioServicesApi studioServicesApi;

    public StudioServicesApi getStudioServicesApi() {
        return studioServicesApi;
    }

    @Autowired
    public void setStudioServicesApi(StudioServicesApi studioServicesApi) {
        this.studioServicesApi = studioServicesApi;
    }

    public List<StudiosDTO> getStudiosByUser(String email) {
        return getStudioServicesApi().getStudiosByUser(email).getBody();
    }
}

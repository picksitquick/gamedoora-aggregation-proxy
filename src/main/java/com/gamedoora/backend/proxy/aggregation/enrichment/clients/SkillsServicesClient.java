package com.gamedoora.backend.proxy.aggregation.enrichment.clients;

import com.gamedoora.backend.proxy.aggregation.enrichment.apis.SkillsServicesApi;
import com.gamedoora.model.dto.SkillsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SkillsServicesClient {
    private SkillsServicesApi skillsServicesApi;

    public SkillsServicesApi getSkillsServicesApi() {
        return skillsServicesApi;
    }
    @Autowired
    public void setSkillsServicesApi(SkillsServicesApi skillsServicesApi) {
        this.skillsServicesApi = skillsServicesApi;
    }

    public List<SkillsDTO> getSkillsForUserByEmail(String email){
        return getSkillsServicesApi().getAllSkillsByEmail(email).getBody();
    }
}

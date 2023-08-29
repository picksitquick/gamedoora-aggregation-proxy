package com.gamedoora.backend.proxy.aggregation.enrichment.clients;

import com.gamedoora.model.dto.RoleDTO;
import com.gamedoora.model.dto.SkillsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RetriableSkillsServicesClient {
 private SkillsServicesClient skillsServicesClient;
  private RetryTemplate retryTemplate;
    public List<SkillsDTO> getSkillsForUserByEmail(String email){
        return getRetryTemplate().execute(retryContext -> {
           return getSkillsServicesClient().getSkillsForUserByEmail(email);
        });
    }


    public RetryTemplate getRetryTemplate() {
        return retryTemplate;
    }

    @Autowired
    public void setRetryTemplate(RetryTemplate retryTemplate) {
        this.retryTemplate = retryTemplate;
    }

    public SkillsServicesClient getSkillsServicesClient() {
        return skillsServicesClient;
    }

    @Autowired
    public void setSkillsServicesClient(SkillsServicesClient skillsServicesClient) {
        this.skillsServicesClient = skillsServicesClient;
    }
}

package com.gamedoora.backend.proxy.aggregation.enrichment.clients;

import com.gamedoora.backend.proxy.aggregation.enrichment.apis.RolesServicesApi;
import com.gamedoora.model.dto.RoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RetriableRolesServicesClient {
  private RolesServicesClient rolesServicesClient;
  private RetryTemplate retryTemplate;
    public List<RoleDTO> getRolesForUserByEmail(String email){
        return getRetryTemplate().execute(retryContext -> {
           return getRolesServicesClient().getRolesForUserByEmail(email);
        });
    }

    public RolesServicesClient getRolesServicesClient() {
        return rolesServicesClient;
    }

    @Autowired
    public void setRolesServicesClient(RolesServicesClient rolesServicesClient) {
        this.rolesServicesClient = rolesServicesClient;
    }

    public RetryTemplate getRetryTemplate() {
        return retryTemplate;
    }

    @Autowired
    public void setRetryTemplate(RetryTemplate retryTemplate) {
        this.retryTemplate = retryTemplate;
    }
}

package com.gamedoora.backend.proxy.aggregation.enrichment.clients;

import com.gamedoora.backend.proxy.aggregation.enrichment.apis.RolesServicesApi;
import com.gamedoora.model.dto.RoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RolesServicesClient {
    private RolesServicesApi rolesServicesApi;

    public RolesServicesApi getRolesServicesApi() {
        return rolesServicesApi;
    }
  @Autowired
    public void setRolesServicesApi(RolesServicesApi rolesServicesApi) {
        this.rolesServicesApi = rolesServicesApi;
    }

    public List<RoleDTO> getRolesForUserByEmail(String email){
        return getRolesServicesApi().getAllRolesByEmail(email).getBody();
    }
}

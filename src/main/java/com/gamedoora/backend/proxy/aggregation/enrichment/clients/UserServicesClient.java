package com.gamedoora.backend.proxy.aggregation.enrichment.clients;

import com.gamedoora.backend.proxy.aggregation.enrichment.apis.UserServicesApi;
import com.gamedoora.model.dto.UserDTO;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServicesClient {
    private UserServicesApi userServicesApi;

    public UserServicesApi getUserServicesApi() {
        return userServicesApi;
    }

    @Autowired
    public void setUserServicesApi(UserServicesApi userServicesApi) {
        this.userServicesApi = userServicesApi;
    }

    UserDTO getUserByEmail(@NonNull String email){
        return getUserServicesApi().getUserByEmail(email).getBody();
    }

    UserDTO addRoleToUser(UserDTO userDTO){return getUserServicesApi().addRoles(userDTO).getBody();}

    UserDTO addSkillToUser(UserDTO userDTO){return getUserServicesApi().addSkills(userDTO).getBody();}
}

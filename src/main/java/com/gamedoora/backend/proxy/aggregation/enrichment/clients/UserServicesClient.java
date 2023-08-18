package com.gamedoora.backend.proxy.aggregation.enrichment.clients;

import com.gamedoora.backend.proxy.aggregation.enrichment.apis.UserServicesApi;
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
}

package com.gamedoora.backend.proxy.aggregation.enrichment.apis;

import com.gamedoora.model.dto.StudiosDTO;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RefreshScope
@FeignClient(value = "studiosClient", url = "{services.studios.url}")
public interface StudioServicesApi {

    @GetMapping(
            value = "/users/{email}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity <List<StudiosDTO>> getStudiosByUser(@PathVariable String email);
}

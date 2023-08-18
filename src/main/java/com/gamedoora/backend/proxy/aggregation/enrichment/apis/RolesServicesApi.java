package com.gamedoora.backend.proxy.aggregation.enrichment.apis;

import com.gamedoora.model.dto.RoleDTO;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RefreshScope
@FeignClient(value = "rolesClient", url = "${service.roles.url}")
public interface RolesServicesApi {
    @PostMapping(value = "/", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<RoleDTO> createRoles(@RequestBody RoleDTO rolesDto);

    @PutMapping(value = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<RoleDTO> updateRoles(@PathVariable("id") long id, @RequestBody RoleDTO rolesDto);

    @DeleteMapping(value = "/{id}")
    ResponseEntity<HttpStatus> deleteRoles(@PathVariable("id") long id);

    @DeleteMapping(value = "/")
    ResponseEntity<HttpStatus> deleteAllRoles();

    @GetMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<List<RoleDTO>> getAllRoles(@RequestParam(required = false) String name);
}

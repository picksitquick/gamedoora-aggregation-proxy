package com.gamedoora.backend.proxy.aggregation.enrichment.apis;

import com.gamedoora.model.dto.UserDTO;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RefreshScope
@FeignClient(value = "usersClient", url = "${service.users.url}")
public interface UserServicesApi {
    @PostMapping(
            value = "/",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<UserDTO> createUsers(@RequestBody UserDTO usersDto);

    @PutMapping(
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<UserDTO> updateUsers(
            @PathVariable("id") long id, @RequestBody UserDTO usersDto);

    @DeleteMapping("/{id}")
    ResponseEntity<HttpStatus> deleteUsers(@PathVariable("id") long id);

    @DeleteMapping("/")
    ResponseEntity<HttpStatus> deleteAllUsers();

    @GetMapping(
            value = "/",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<List<UserDTO>> getAllUsers(@RequestParam(required = false) String name);

    @GetMapping(
            value = "/{name}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<List<UserDTO>> getAllUsersByName(@PathVariable String name);

    @GetMapping(
            value = "/skills/{name}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<List<UserDTO>> getAllUsersBySkillsName(@PathVariable String name);

    @GetMapping(
            value = "/roles/{name}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<List<UserDTO>> getAllUsersByRoles(@PathVariable String name)//confirm mapping
    ;

    @GetMapping(
            value = "/email",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<UserDTO> getUserByEmail(@RequestParam(required = true) String email);
}

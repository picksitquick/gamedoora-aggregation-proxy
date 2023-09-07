package com.gamedoora.backend.proxy.aggregation.enrichment.apis;

import com.gamedoora.model.dto.SkillsDTO;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RefreshScope
@FeignClient(value = "skillsClient", url = "${service.skills.url}")
public interface SkillsServicesApi {
    @PostMapping(value = "/", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<SkillsDTO> createSkills(@RequestBody SkillsDTO skillsDto);

    @PutMapping(value = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<SkillsDTO> updateSkills(@PathVariable("id") long id, @RequestBody SkillsDTO skillsDto);

    @DeleteMapping("/{id}")
    ResponseEntity<HttpStatus> deleteSkills(@PathVariable("id") long id);

    @DeleteMapping("/")
    ResponseEntity<HttpStatus> deleteAllSkills();

    @GetMapping(
            value = "/",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<List<SkillsDTO>> getAllSkills(@RequestParam(required = false) String name);
    @GetMapping(
            value = "/users",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<List<SkillsDTO>> getAllSkillsByEmail(@RequestParam(required = true) String email);
}

package com.gamedoora.backend.proxy.aggregation.enrichment.apis;

import com.gamedoora.model.dto.SourceDTO;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RefreshScope
@FeignClient(value = "sourcesClient", url = "${service.sources.url}")
public interface SourcesServicesApi {
    @PostMapping(value = "/", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<SourceDTO> createSources(@RequestBody SourceDTO sourcesDto);

    @PutMapping(value = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<SourceDTO> updateSources(
            @PathVariable("id") long id, @RequestBody SourceDTO sourceDTO);

    @DeleteMapping(value = "/{id}")
    ResponseEntity<HttpStatus> deleteSources(@PathVariable("id") long id);

    @DeleteMapping(value = "/")
    ResponseEntity<HttpStatus> deleteAllSources();

    @GetMapping(
            value = "/",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<List<SourceDTO>> getAllSources(@RequestParam(required = false) String name);
}

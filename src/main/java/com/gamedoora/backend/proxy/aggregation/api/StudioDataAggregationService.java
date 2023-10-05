package com.gamedoora.backend.proxy.aggregation.api;

import com.gamedoora.backend.proxy.aggregation.assembler.StudioDataAggregatorAssembler;
import com.gamedoora.model.dto.GdUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/aggregate/studios")
public class StudioDataAggregationService {
    private StudioDataAggregatorAssembler studioDataAggregatorAssembler;

    @RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public GdUser getStudiosByUser(@RequestParam("email") String email){
        return getStudioDataAggregatorAssembler().getStudiosByUser(email);
    }

    public StudioDataAggregatorAssembler getStudioDataAggregatorAssembler() {
        return studioDataAggregatorAssembler;
    }

    @Autowired
    public void setStudioDataAggregatorAssembler(StudioDataAggregatorAssembler studioDataAggregatorAssembler) {
        this.studioDataAggregatorAssembler = studioDataAggregatorAssembler;
    }
}

package com.gamedoora.backend.proxy.aggregation.api;

import com.gamedoora.backend.proxy.aggregation.assembler.UserDataAggregatorAssembler;
import com.gamedoora.model.dto.GdUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/aggregate/users")
public class UserDataAggregationService {
    private UserDataAggregatorAssembler aggregatorAssembler;

    @RequestMapping(value = "/email", produces = MediaType.APPLICATION_JSON_VALUE)
    public GdUser getUserProfileByEmail(@RequestParam("emailId") String email){
        return getAggregatorAssembler().getUserByEmail(email);
    }
    public UserDataAggregatorAssembler getAggregatorAssembler() {
        return aggregatorAssembler;
    }

    @Autowired
    public void setAggregatorAssembler(UserDataAggregatorAssembler aggregatorAssembler) {
        this.aggregatorAssembler = aggregatorAssembler;
    }
}

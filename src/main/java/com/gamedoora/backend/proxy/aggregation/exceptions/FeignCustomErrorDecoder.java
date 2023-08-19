package com.gamedoora.backend.proxy.aggregation.exceptions;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;

@Slf4j
public class FeignCustomErrorDecoder implements ErrorDecoder {

    @Override public Exception decode(String methodKey, Response response) {
        ClientResponseExceptionMessage message = null;
        try {
            message = extractErrorMessage(response, new ClientResponseExceptionMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        log.error("Client call={0} failed with exception{1}".formatted(methodKey, message));
        return new ClientResponseException(
                message.getMessage(),
                response.status()

        );

    }

    private ClientResponseExceptionMessage extractErrorMessage(Response response, ClientResponseExceptionMessage message) throws IOException {

        try (InputStream bodyIs = response.body()
                .asInputStream()) {
            ObjectMapper mapper = new ObjectMapper();
            message = mapper.readValue(bodyIs, ClientResponseExceptionMessage.class);
        }
        return message;
    }

}
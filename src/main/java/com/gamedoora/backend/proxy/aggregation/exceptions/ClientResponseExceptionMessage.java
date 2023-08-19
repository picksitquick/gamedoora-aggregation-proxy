package com.gamedoora.backend.proxy.aggregation.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
public class ClientResponseExceptionMessage {
    private String timestamp;
    private int status;
    private String error;
    private String message;
    private String path;
}

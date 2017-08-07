package com.zoutly.api.resource;

import lombok.Data;

@Data
public class ResponseStatus {

    ResponseStatus.Type type;
    int code;
    String message;

    public enum Type {
        INFO, ERROR, WARNING
    }
}


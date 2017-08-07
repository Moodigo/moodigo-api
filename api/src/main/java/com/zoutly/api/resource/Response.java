package com.zoutly.api.resource;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class Response<T> {

    @NonNull
    T payload;

    ResponseStatus status;

    ResponseMeta meta;
}
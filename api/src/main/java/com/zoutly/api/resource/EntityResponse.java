package com.zoutly.api.resource;

import lombok.Data;

@Data
public class EntityResponse<E> extends Response<E> {

    public EntityResponse(E payload) {
        this.payload = payload;
    }
}

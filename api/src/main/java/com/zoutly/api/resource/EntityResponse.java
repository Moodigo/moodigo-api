package com.zoutly.api.resource;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class EntityResponse<E> extends Response<E> {

    public EntityResponse(E payload) {
        this.payload = payload;
    }
}

package com.zoutly.api.resource;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class EntityListResponse<E> extends Response<List<E>> {

    public EntityListResponse(List<E> payload) {
        this.payload = payload;
        this.status = null;
        this.meta = null;
    }
}

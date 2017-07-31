package com.zoutly.api.resource;

import lombok.Data;
import lombok.NonNull;

@Data
public class EntityData<E> extends BaseData {

    @NonNull
    private final E entity;
}

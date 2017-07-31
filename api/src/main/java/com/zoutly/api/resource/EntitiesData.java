package com.zoutly.api.resource;

import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class EntitiesData<E> extends BaseData {

    @NonNull
    private final List<E> entities;
}

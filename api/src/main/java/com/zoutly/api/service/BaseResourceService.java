package com.zoutly.api.service;

import com.zoutly.api.resource.EntitiesData;
import com.zoutly.api.resource.EntityData;

public interface BaseResourceService<E> {

    EntitiesData<E> createAll();
    EntityData<E> createById(long id);

}

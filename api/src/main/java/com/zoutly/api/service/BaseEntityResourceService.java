package com.zoutly.api.service;

import com.zoutly.api.resource.EntitiesData;
import com.zoutly.api.resource.EntityData;

import java.util.List;

public interface BaseEntityResourceService<E> extends BaseEntityService<E>, BaseResourceService<E> {

    EntityData<E> convertEntityToData(E entity);
    E convertDataToEntity(EntityData<E> date);
    List<E> convertDataToEntites(EntitiesData<E> date);

}

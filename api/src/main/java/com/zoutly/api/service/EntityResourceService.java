package com.zoutly.api.service;

import com.zoutly.api.resource.EntityListResponse;
import com.zoutly.api.resource.EntityResponse;
import com.zoutly.core.model.BaseEntity;
import com.zoutly.core.service.EntityService;

public interface EntityResourceService<E extends BaseEntity> extends EntityService<E> {

    default EntityListResponse<E> buildAll() {
        return new EntityListResponse<>(getAll());
    }

    default EntityResponse<E> buildById(long id) {
        return new EntityResponse<>(getById(id));
    }

    // TODO
//    EntityResponse<E> convertEntityToData(E entity);
//    E convertDataToEntity(EntityResponse<E> date);
//    List<E> convertDataToEntites(EntityListResponse<E> date);

}

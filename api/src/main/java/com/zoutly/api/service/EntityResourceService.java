package com.zoutly.api.service;

import com.zoutly.api.resource.EntityListResponse;
import com.zoutly.api.resource.EntityResponse;
import com.zoutly.core.service.EntityService;

public interface EntityResourceService<E> extends EntityService<E> {

    EntityListResponse<E> buildAll();

    EntityResponse<E> buildById(long id);

    // TODO
//    EntityResponse<E> convertEntityToData(E entity);
//    E convertDataToEntity(EntityResponse<E> date);
//    List<E> convertDataToEntites(EntityListResponse<E> date);

}

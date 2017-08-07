package com.zoutly.api.service;

import com.zoutly.api.resource.EntityListResponse;
import com.zoutly.api.resource.EntityResponse;

import java.util.List;

public interface EntityResourceService<E> {

    E getById(long id);

    List<E> getAll();

    EntityListResponse<E> buildAll();

    EntityResponse<E> buildById(long id);

    // TODO
//    EntityResponse<E> convertEntityToData(E entity);
//    E convertDataToEntity(EntityResponse<E> date);
//    List<E> convertDataToEntites(EntityListResponse<E> date);

}

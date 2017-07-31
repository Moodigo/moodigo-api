package com.zoutly.api.service;

import java.util.List;

public interface BaseEntityService<E> {

    E getById(long id);
    List<E> getAll();
}

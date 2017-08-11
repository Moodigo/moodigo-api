package com.zoutly.core.service;

import java.util.List;

public interface EntityService<E> {

    E getById(long id);

    List<E> getAll();

}

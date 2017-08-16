package com.zoutly.core.service;

import com.zoutly.core.dao.BaseDAO;
import com.zoutly.core.model.BaseEntity;

import java.util.List;

public interface EntityService<E extends BaseEntity> {

    default E getById(long id) {
        return getDAO().findByPK(id);
    }

    default List<E> getAll() {
        return getDAO().findAll();
    }

    BaseDAO<E> getDAO();

}

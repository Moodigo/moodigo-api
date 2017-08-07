package com.zoutly.api.service.impl;

import com.zoutly.api.dao.DummyDAO;
import com.zoutly.api.entity.Dummy;
import com.zoutly.api.resource.EntityListResponse;
import com.zoutly.api.resource.EntityResponse;
import com.zoutly.api.service.DummyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DummyServiceImpl implements DummyService {

    @Autowired
    DummyDAO dummyDAO;

    //
    // ENTITY
    //

    @Override
    public List<Dummy> getAll() {
        return dummyDAO.findAll();
    }

    @Override
    public Dummy getById(long id) {
        return dummyDAO.findByPK(id);
    }

    //
    // RESOURCE
    //

    @Override
    public EntityListResponse<Dummy> buildAll() {
        EntityListResponse<Dummy> res = new EntityListResponse<Dummy>(this.getAll());
        return res;
    }

    @Override
    public EntityResponse<Dummy> buildById(long id) {
        EntityResponse<Dummy> res = new EntityResponse<Dummy>(this.getById(id));
        return res;
    }

}

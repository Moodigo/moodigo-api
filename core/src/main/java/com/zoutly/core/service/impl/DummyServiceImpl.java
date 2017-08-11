package com.zoutly.core.service.impl;

import com.zoutly.core.dao.DummyDAO;
import com.zoutly.core.entity.Dummy;
import com.zoutly.core.service.DummyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DummyServiceImpl implements DummyService {

    @Autowired
    protected DummyDAO dummyDAO;

    @Override
    public List<Dummy> getAll() {
        return dummyDAO.findAll();
    }

    @Override
    public Dummy getById(long id) {
        return dummyDAO.findByPK(id);
    }

}

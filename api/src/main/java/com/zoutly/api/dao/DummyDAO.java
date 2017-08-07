package com.zoutly.api.dao;

import com.zoutly.api.entity.Dummy;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class DummyDAO extends EntityDAO {

    public Dummy findByPK(Serializable pk) {
        return this.findByPK(pk, Dummy.class);
    }

    public List<Dummy> findAll() {
        return this.findAll(Dummy.class);
    }
}

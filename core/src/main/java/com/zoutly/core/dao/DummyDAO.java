package com.zoutly.core.dao;

import com.zoutly.core.entity.Dummy;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public class DummyDAO extends EntityDAO {

    public Dummy findByPK(Serializable pk) {
        return this.findByPK(pk, Dummy.class);
    }

    public List<Dummy> findAll() {
        return this.findAll(Dummy.class);
    }
}

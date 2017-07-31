package com.zoutly.api.service;

import com.zoutly.api.entity.Dummy;
import com.zoutly.api.resource.EntitiesData;
import com.zoutly.api.resource.EntityData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DummyServiceImpl implements DummyService {

    //
    // ENTITY
    //

    @Override
    public List<Dummy> getAll() {
        List<Dummy> res = new ArrayList();

        // TODO DAO call instead
        res.add(new Dummy(1, "Dummy #1"));
        res.add(new Dummy(10, "Dummy #10"));
        res.add(new Dummy(2, "Dummy #2"));
        res.add(new Dummy(3, "Dummy #3"));
        res.add(new Dummy(4, "Dummy #4"));

        return res;
    }

    @Override
    public Dummy getById(long id) {

        // TODO DAO call instead
        Dummy res = new Dummy(id, "Dummy #" + id);

        return res;
    }

    //
    // RESOURCE
    //

    @Override
    public EntitiesData<Dummy> createAll() {

        EntitiesData<Dummy> res = new EntitiesData<>(this.getAll());
        return res;
    }

    @Override
    public EntityData<Dummy> createById(long id) {

        EntityData<Dummy> res = new EntityData<Dummy>(this.getById(id));
        return res;
    }

    // TODO move to abstract class
    protected EntityData<Dummy> convertEntityToData(Dummy entity) {
        return new EntityData<Dummy>(entity);
    }

}

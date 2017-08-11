package com.zoutly.api.service.impl;

import com.zoutly.api.resource.EntityListResponse;
import com.zoutly.api.resource.EntityResponse;
import com.zoutly.api.service.DummyApiService;
import com.zoutly.core.entity.Dummy;
import com.zoutly.core.service.impl.DummyServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class DummyApiServiceImpl extends DummyServiceImpl implements DummyApiService {

    //
    // RESOURCE
    //

    @Override
    public EntityListResponse<Dummy> buildAll() {
        EntityListResponse<Dummy> res = new EntityListResponse<>(this.getAll());
        return res;
    }

    @Override
    public EntityResponse<Dummy> buildById(long id) {
        EntityResponse<Dummy> res = new EntityResponse<>(this.getById(id));
        return res;
    }

}

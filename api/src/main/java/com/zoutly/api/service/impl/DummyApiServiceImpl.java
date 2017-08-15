package com.zoutly.api.service.impl;

import com.zoutly.api.resource.EntityListResponse;
import com.zoutly.api.resource.EntityResponse;
import com.zoutly.api.service.DummyApiService;
import com.zoutly.core.model.Dummy;
import com.zoutly.core.service.impl.DummyServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class DummyApiServiceImpl extends DummyServiceImpl implements DummyApiService {

    //
    // RESOURCE
    //

    @Override
    public EntityListResponse<Dummy> buildAll() {
        return new EntityListResponse<>(this.getAll());
    }

    @Override
    public EntityResponse<Dummy> buildById(long id) {
        return new EntityResponse<>(this.getById(id));
    }

}

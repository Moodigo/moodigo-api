package com.zoutly.api.service.impl;

import com.zoutly.api.resource.EntityListResponse;
import com.zoutly.api.resource.EntityResponse;
import com.zoutly.api.service.UserApiService;
import com.zoutly.core.model.User;
import com.zoutly.core.service.impl.UserServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserApiServiceImpl extends UserServiceImpl implements UserApiService {

    @Override
    public EntityListResponse<User> buildAll() {
        return new EntityListResponse<>(getAll());
    }

    @Override
    public EntityResponse<User> buildById(long id) {
        return new EntityResponse<>(getById(id));
    }
}

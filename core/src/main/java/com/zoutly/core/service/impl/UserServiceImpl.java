package com.zoutly.core.service.impl;

import com.zoutly.core.dao.UserDAO;
import com.zoutly.core.service.UserService;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    @Getter
    @Accessors(prefix = "user")
    protected UserDAO userDAO;

}

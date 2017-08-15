package com.zoutly.core.service.impl;

import com.zoutly.core.dao.UserDAO;
import com.zoutly.core.model.User;
import com.zoutly.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    protected UserDAO userDAO;

    @Override
    public List<User> getAll() {
        return userDAO.findAll();
    }

    @Override
    public User getById(long id) {
        return userDAO.findByPK(id);
    }

}

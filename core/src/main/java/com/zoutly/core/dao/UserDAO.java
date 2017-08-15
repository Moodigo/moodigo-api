package com.zoutly.core.dao;

import com.zoutly.core.model.User;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public class UserDAO extends EntityDAO {

    public User findByPK(Serializable pk) {
        return this.findByPK(pk, User.class);
    }

    public List<User> findAll() {
        return this.findAll(User.class);
    }
}

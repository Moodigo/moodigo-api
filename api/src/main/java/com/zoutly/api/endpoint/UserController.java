package com.zoutly.api.endpoint;

import com.zoutly.api.resource.EntityResponse;
import com.zoutly.api.service.UserApiService;
import com.zoutly.core.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UserController.URI)
public class UserController implements ApiInterface {
    protected static final String URI = ApiInterface.API_URI + "/users";

    @Autowired
    UserApiService userService;

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public EntityResponse<User> getUserDetail(@PathVariable long id) {
        // TODO userAuth interceptor needed and send different info about user depending on user role
        return userService.buildById(id);
    }
}

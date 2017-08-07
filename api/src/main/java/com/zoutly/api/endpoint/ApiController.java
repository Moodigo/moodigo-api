package com.zoutly.api.endpoint;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiInterface.API_URI)
public class ApiController implements ApiInterface {

    @RequestMapping(method = RequestMethod.GET)
    public String getVersion() {
        // TODO lets return api version
        return "SNAPCHAT";
    }
}

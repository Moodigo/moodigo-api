package com.zoutly.api.endpoint;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {

    @RequestMapping(method = RequestMethod.GET)
    public String getApiVersion() {
        return "0.0.1-SNAPSHOT";
    }
}

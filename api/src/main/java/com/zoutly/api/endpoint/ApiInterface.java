package com.zoutly.api.endpoint;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(ApiInterface.API_URI)
public interface ApiInterface {
    public static final String API_URI = "/api";
}

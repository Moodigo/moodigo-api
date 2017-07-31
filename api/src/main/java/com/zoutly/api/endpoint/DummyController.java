package com.zoutly.api.endpoint;

import com.zoutly.api.entity.Dummy;
import com.zoutly.api.resource.EntitiesData;
import com.zoutly.api.resource.EntityData;
import com.zoutly.api.service.DummyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DummyController {

    @Autowired
    DummyService dummyService;

    @RequestMapping(method = RequestMethod.GET, path = "/dummies")
    public EntitiesData<Dummy> getAllDummies() {
        return dummyService.createAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/dummies/{id}")
    public EntityData<Dummy> getDummy(@RequestParam(value = "id") Long id) {
        return dummyService.createById(id);
    }
}
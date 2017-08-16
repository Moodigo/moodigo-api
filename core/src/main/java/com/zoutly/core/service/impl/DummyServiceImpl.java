package com.zoutly.core.service.impl;

import com.zoutly.core.dao.DummyDAO;
import com.zoutly.core.service.DummyService;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DummyServiceImpl implements DummyService {

    @Autowired
    @Getter
    @Accessors(prefix = "dummy") // prefixes are ignored, so it will generate getDAO needed for EntityService
    protected DummyDAO dummyDAO;

}

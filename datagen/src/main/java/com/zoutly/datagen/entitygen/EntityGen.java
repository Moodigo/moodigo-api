package com.zoutly.datagen.entitygen;

import com.zoutly.core.dao.DummyDAO;
import com.zoutly.core.entity.Dummy;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EntityGen implements CommandLineRunner {

    @Autowired
    private DummyDAO dummyDAO;

    public void run(String... args) throws Exception {

        generateDummy(args);

        System.exit(0);
    }

    private void generateDummy(String... args) {
        DataFactory df = new DataFactory();

        for(int i = 0; i < 100; i++) {
            Dummy d = new Dummy(df.getRandomWord());
            dummyDAO.save(d);
        }

    }

}

package com.zoutly.datagen.entitygen;

import com.zoutly.core.dao.DummyDAO;
import com.zoutly.core.dao.EntityDAO;
import com.zoutly.core.dao.UserDAO;
import com.zoutly.core.model.Dummy;
import com.zoutly.core.model.User;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EntityGen implements CommandLineRunner {

    @Autowired
    private EntityDAO entityDAO;

    @Autowired
    private DummyDAO dummyDAO;

    @Autowired
    private UserDAO userDAO;


    private DataFactory df = new DataFactory();

    public void run(String... args) throws Exception {

        generateDummies(args);
        generateUsers(args);

        System.exit(0);
    }

    private void generateDummies(String... args) {
        for(int i = 0; i < 100; i++) {
            Dummy d = new Dummy(df.getRandomWord());
            entityDAO.save(d);
        }
    }

    private void generateUsers(String... args) {
        for(int i = 0; i < 10000; i++) {
            User u = new User(df.getFirstName(), df.getLastName());
            userDAO.save(u);
        }
    }

}

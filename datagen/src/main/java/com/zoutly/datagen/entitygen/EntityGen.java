package com.zoutly.datagen.entitygen;

import com.zoutly.core.dao.BaseDAO;
import com.zoutly.core.dao.DummyDAO;
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
    private BaseDAO baseDAO;

    @Autowired
    private DummyDAO dummyDAO;

    @Autowired
    private UserDAO userDAO;

    private DataFactory df = new DataFactory();

    public void run(String... args) throws Exception {

        generateDummies(args);
        generateUsers(args);
        modifyDummies(args);

        System.exit(0);
    }

    private void generateDummies(String... args) {
        for(int i = 0; i < 100; i++) {
            Dummy d = new Dummy(df.getRandomWord());
            baseDAO.save(d, null);
        }
    }

    private void generateUsers(String... args) {
        for(int i = 0; i < 1000; i++) {
            User u = new User(df.getFirstName(), df.getLastName());
            userDAO.save(u, null);
        }
    }

    private void modifyDummies(String... arg) {

        for(long i = 1; i <= 50; i++) {
            Dummy d = dummyDAO.findByPK(i);
            User u = userDAO.findByPK(51 - i);

            d.setValue(df.getRandomWord());
            dummyDAO.save(d, u);
        }
    }

}

package com.zoutly.core.utils;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class DAOUtils {

    private final static Logger logger = LoggingUtils.getLogger(DAOUtils.class);

    private static final SessionFactory sessionFactory = buildSessionFactory();

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    private static SessionFactory buildSessionFactory() {

        try {
            // Create the ServiceRegistry from hibernate.cfg.xml
            final ServiceRegistry serviceRegistry =
                    new StandardServiceRegistryBuilder()
                            .configure("hibernate.cfg.xml")
                            .build();

            // Create a metadata sources using the specified service registry.
            Metadata metadata =
                    new MetadataSources(serviceRegistry)
                            .getMetadataBuilder()
                            .build();

            // Create SessionFactory
            return metadata.getSessionFactoryBuilder().build();
        } catch(Throwable ex) {
            logger.error("Initial SessionFactory creation failed.", ex);

            // TODO with possibly thrown exceptions it cannot be mvn install
            // throw new ExceptionInInitializerError(ex);
        }

        return null;
    }

}

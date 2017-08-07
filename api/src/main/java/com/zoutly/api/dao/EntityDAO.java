package com.zoutly.api.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class EntityDAO {

    protected static final SessionFactory sessionFactory = buildSessionFactory();

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
            // TODO set loggers LOG4j
            System.err.println("Initial SessionFactory creation failed." + ex);

            // TODO with possibly thrown exceptions it cannot be mvn install
            // throw new ExceptionInInitializerError(ex);
        }

        return null;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * Creates entry in DB for entity or updates entity.
     *
     * @param entity
     */
    public void save(Object entity) {
        Session session = getSessionFactory().getCurrentSession();
        Transaction trans = session.beginTransaction();
        session.saveOrUpdate(entity);
        trans.commit();
    }

    /**
     * Deletes DB entry of entity.
     *
     * @param entity
     */
    public void delete(Object entity) {
        Session session = getSessionFactory().getCurrentSession();
        Transaction trans = session.beginTransaction();
        session.delete(entity);
        trans.commit();
    }

    /**
     * Finds entity by PK.
     *
     * @param pk          Primary key
     * @param entityClass
     * @return entity object or null
     */
    public <T> T findByPK(Serializable pk, Class<T> entityClass) {
        Session session = getSessionFactory().getCurrentSession();
        Transaction trans = session.beginTransaction();
        T entity = session.get(entityClass, pk);
        trans.commit();

        return entity;
    }

    /**
     * Finds all entities.
     *
     * @param entityClass
     * @return (possibly empty) {@link List} of entity objects
     */
    public <T> List<T> findAll(Class<T> entityClass) {
        Session session = getSessionFactory().getCurrentSession();
        Transaction trans = session.beginTransaction();
        // TODO deprecated!
        Criteria criteria = session.createCriteria(entityClass);
        criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        criteria.setCacheable(true);
        List<T> res = criteria.list();
        trans.commit();

        return res;
    }

}

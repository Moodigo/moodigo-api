package com.zoutly.core.dao;

import com.zoutly.core.model.BaseEntity;
import com.zoutly.core.model.User;
import com.zoutly.core.utils.DAOUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaSpecification;
import org.springframework.core.GenericTypeResolver;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public class BaseDAO<E extends BaseEntity> {

    private final Class<E> genericType;

    public BaseDAO() {
        this.genericType = (Class<E>) GenericTypeResolver.resolveTypeArgument(getClass(), BaseDAO.class);
    }

    /**
     * Creates entry in DB for entity or updates entity.
     *
     * @param entity Entity to be saved
     * @param user   User who made changes or null if system change
     */
    public void save(E entity, User user) {
        Session session = DAOUtils.getSession();
        Transaction trans = session.beginTransaction();

        entity.setModification(user);
        session.saveOrUpdate(entity);

        trans.commit();
    }

    /**
     * Deletes DB entry of entity.
     *
     * @param entity Entity to be deleted
     */
    public void delete(E entity) {
        Session session = DAOUtils.getSession();
        Transaction trans = session.beginTransaction();

        session.delete(entity);

        trans.commit();
    }

    /**
     * Finds entity by PK.
     *
     * @param pk primary key
     * @return Entity or null
     */
    public E findByPK(Serializable pk) {
        Session session = DAOUtils.getSession();
        Transaction trans = session.beginTransaction();

        E entity = session.get(genericType, pk);

        trans.commit();
        return entity;
    }

    /**
     * Finds all entities.
     *
     * @return (possibly empty) {@link List} of entity objects
     */
    public List<E> findAll() {
        Session session = DAOUtils.getSession();
        Transaction trans = session.beginTransaction();
        // TODO deprecated!
        Criteria criteria = session.createCriteria(genericType);
        criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        criteria.setCacheable(true);
        List<E> res = criteria.list();
        trans.commit();

        return res;
    }

}

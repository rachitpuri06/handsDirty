/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.automation.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author rachit
 * @param <T>
 */
public abstract class GenericDAO<T extends Serializable> {

    private Class< T> clazz;

    @Autowired
    private SessionFactory sessionFactory;

    public T findById(final Integer id) {
        return (T) getCurrentSession().get(clazz, id);
    }

    public void save(final T entity) {
        getCurrentSession().persist(entity);
    }

    public void saveOrUpdate(final List<T> entities) {
        saveOrUpdate(entities, false);
    }

    public void saveOrUpdate(final List<T> entities, boolean clearSessionCache) {
        int i = 0;
        for (T entity : entities) {
            saveOrUpdate(entity);
            if (clearSessionCache == true && ++i == 20) {
                getCurrentSession().flush();
                getCurrentSession().clear();
                i = 0;
            }
        }
    }

    public void saveOrUpdate(final T entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    public List<T> findAll() {
        return getCurrentSession().createCriteria(clazz).list();
    }

    public T findByNamedQueryUnique(String sql, Map<String, Object> paramMap) {
        List<T> list = getNamedQuery(sql, paramMap).list();
        if (list.isEmpty()) {
            return null;
        } else {
            return list.get(0);
        }
    }

    public List<T> findByNamedQueryList(
            String sql,
            Map<String, Object> paramMap,
            Integer batchSize,
            Integer pageNo
    ) {
        Query query = getNamedQuery(sql, paramMap);
        if (pageNo != null && pageNo >= 0
                && batchSize != null && batchSize > 0) {
            query.setMaxResults(batchSize);
            query.setFirstResult(pageNo * batchSize);
        }
        return query.list();
    }

    public Integer deleteByNamedQuery(String sql) {
        Query query = getCurrentSession().getNamedQuery(sql);
        return query.executeUpdate();
    }

    public List<T> findByNamedQueryList(String sql, Map<String, Object> paramMap) {
        return getNamedQuery(sql, paramMap).list();
    }

//   public List<T> findByNamedQueryInstance(String sql, Map<String,Object> paramMap){
//      return getNamedQuery(sql, paramMap).
//   }
    private Query getNamedQuery(String sql, Map<String, Object> paramMap) {
        Query query = getCurrentSession().getNamedQuery(sql);
        if (paramMap != null) {
            for (String key : paramMap.keySet()) {
                query.setParameter(key, paramMap.get(key));
            }
        }
        return query;
    }

    public T update(final T entity) {
        return (T) getCurrentSession().merge(entity);
    }

    public void delete(final T entity) {
        getCurrentSession().delete(entity);
    }

    public void deleteAll(final List<T> entities) {
        for (T entity : entities) {
            delete(entity);
        }
    }

    public void deleteById(final Integer id) {
        final T entity = findById(id);
        delete(entity);
    }

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void updateAll(final List<T> entities) {
        for (T entity : entities) {
            getCurrentSession().merge(entity);
        }
    }

    public Serializable saveAndReturn(final T entity) {
        return getCurrentSession().save(entity);
    }

    /**
     * @param clazz the clazz to set
     */
    public void setClazz(Class< T> clazz) {
        this.clazz = clazz;
    }

    /**
     * @param sessionFactory the sessionFactory to set
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Object getGenericDataFromSql(String sql) {
        Query query = getCurrentSession().createSQLQuery(sql);
        return query.uniqueResult();
    }

    public StatelessSession getStatelessSession() {
        return sessionFactory.openStatelessSession();
    }

//    public void bulkOperations(List<T> entities, BulkOperations bulkOperation) {
//        StatelessSession session = getStatelessSession();
//        Transaction tx = session.beginTransaction();
//        if (BulkOperations.UPDATE.equals(bulkOperation)) {
//            bulkUpdate(session, entities);
//        } else if (BulkOperations.INSERT.equals(bulkOperation)) {
//            bulkInsert(session, entities);
//        } else if (BulkOperations.DELETE.equals(bulkOperation)) {
//            bulkDelete(session, entities);
//        }
//        tx.commit();
//        session.close();
//    }
    public void bulkUpdate(StatelessSession session, List<T> entities) {
        for (T entity : entities) {
            session.update(entity);
        }
    }

    public void bulkInsert(StatelessSession session, List<T> entities) {
        for (T entity : entities) {
            session.insert(entity);
        }
    }

    public void bulkDelete(StatelessSession session, List<T> entities) {
        for (T entity : entities) {
            session.delete(entity);
        }
    }
}

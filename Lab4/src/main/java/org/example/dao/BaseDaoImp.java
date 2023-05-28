package org.example.dao;

import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.io.Serializable;
import java.util.List;
//Session используется для работы с базой данных
public class BaseDaoImp <T, Id extends Serializable> extends AbstractDao implements IBaseDao<T,Id> {
    public BaseDaoImp(Class clz) {
        super(clz);
        openSession();
    }

    @Override
    public Id save(Object entity) {
        Transaction t = getSession().beginTransaction();
        Id result = (Id) getSession().save(entity);
        t.commit();
        return result;
    }

    @Override
    public void update(Object entity) {
        Transaction t = getSession().beginTransaction();
        getSession().update(entity);
        t.commit();
    }

    @Override
    public T findOne(Id id) {return (T) getSession().get(getClz(), id);}

    @Override
    public List<T> findAll() {
        Query q = getSession().createQuery("FROM "+ getClz().getName() );
        return q.list();
    }

    @Override
    public void delete(T entity) {
        Transaction t = getSession().beginTransaction();
        getSession().delete(entity);
        t.commit();
    }
}

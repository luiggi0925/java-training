package edu.globant.finalproject.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unchecked")
@Repository
public abstract class GenericDAOImpl<E,K extends Serializable> implements GenericDAO<E, K>{
	
	@Autowired
    private SessionFactory sessionFactory;
     
    protected Class<? extends E> daoType;
    
    public GenericDAOImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        daoType = (Class) pt.getActualTypeArguments()[0];
    }
     
    protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }
     
    @Override
    public void add(E entity) {
        currentSession().save(entity);
    }
     
    @Override
    public void saveOrUpdate(E entity) {
        currentSession().saveOrUpdate(entity);
    }
     
    @Override
    public void update(E entity) {
        currentSession().saveOrUpdate(entity);
    }
     
    @Override
    public void remove(E entity) {
        currentSession().delete(entity);
    }
     
    @Override
    public E find(K key) {
        return (E) currentSession().get(daoType, key);
    }
     
    @Override
    public List<E> getAll() {
    	List<E> lis = currentSession().createCriteria(daoType).list();
    	System.out.println("cantidad de objetos obtenidos: "+lis.size());
    	return lis;
    }
}

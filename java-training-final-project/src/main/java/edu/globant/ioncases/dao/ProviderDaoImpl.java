/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.dao;

import edu.globant.ioncases.model.Provider;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author federico.calarco
 */
@Repository
@Transactional
public class ProviderDaoImpl implements ProviderDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Provider getById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addProvider(Provider provider) {
        getCurrentSession().save(provider);
    }

    @Override
    public List<Provider> getAll() {
        return getCurrentSession().createCriteria(Provider.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

}
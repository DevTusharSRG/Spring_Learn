package com.GovernmentSchemes.GovernmentSchemes.dao.impl;

import com.GovernmentSchemes.GovernmentSchemes.dao.GovernmentSchemeDAO;
import com.GovernmentSchemes.GovernmentSchemes.model.GovernmentScheme;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GovernmentSchemeDAOImpl implements GovernmentSchemeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void save(GovernmentScheme scheme) {
        getSession().save(scheme);
    }

    @Override
    public List<GovernmentScheme> getAll() {
        return getSession().createQuery("from GovernmentScheme", GovernmentScheme.class).list();
    }

    @Override
    public GovernmentScheme getById(int id) {
        return getSession().get(GovernmentScheme.class, id);
    }

    @Override
    public void update(GovernmentScheme scheme) {
        getSession().update(scheme);
    }

    @Override
    public void delete(int id) {
        GovernmentScheme scheme = getById(id);
        if (scheme != null) {
            getSession().delete(scheme);
        }
    }
}

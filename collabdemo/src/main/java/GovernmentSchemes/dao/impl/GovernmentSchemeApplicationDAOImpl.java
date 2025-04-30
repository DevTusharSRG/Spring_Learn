package GovernmentSchemes.dao.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import GovernmentSchemes.dao.GovernmentSchemeApplicationDAO;
import GovernmentSchemes.model.GovernmentSchemeApplication;

@Repository
public class GovernmentSchemeApplicationDAOImpl implements GovernmentSchemeApplicationDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    @Transactional
    public void save(GovernmentSchemeApplication app) {
        getSession().save(app);
    }

    @Override
    @Transactional
    public List<GovernmentSchemeApplication> getAll() {
        return getSession()
            .createQuery("from GovernmentSchemeApplication", GovernmentSchemeApplication.class)
            .list();
    }

    @Override
    @Transactional
    public GovernmentSchemeApplication getById(int id) {
        return getSession().get(GovernmentSchemeApplication.class, id);
    }

    @Override
    @Transactional
    public void update(GovernmentSchemeApplication app) {
        getSession().update(app);
    }

    @Override
    @Transactional
    public void delete(int id) {
        GovernmentSchemeApplication app = getById(id);
        if (app != null) {
            getSession().delete(app);
        }
    }
}

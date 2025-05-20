package com.finalpro.ServiceRequest.dao.impl;

import com.finalpro.ServiceRequest.dao.AgreementDAO;
import com.finalpro.ServiceRequest.model.Agreement;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public class AgreementDAOImpl implements AgreementDAO {

    @Autowired
    private SessionFactory sessionFactory;

    // Save a new agreement
    @Transactional
    public Agreement save(Agreement agreement) {
        Session session = sessionFactory.getCurrentSession();  // Get the current session
        session.persist(agreement);  // Persist the entity
        return agreement;  // Return the saved agreement (with auto-generated ID)
    }

    // Find an agreement by its ID
    @Transactional
    public Agreement findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Agreement.class, id);  // Retrieve the agreement by its ID
    }

    // Update the status of an existing agreement
    @Transactional
    public Agreement updateStatus(Long agreementId, String status) {
        Session session = sessionFactory.getCurrentSession();
        Agreement agreement = session.get(Agreement.class, agreementId);  // Fetch agreement by ID

        if (agreement != null) {
            agreement.setStatus(status);  // Update the status
            session.update(agreement);  // Save the updated entity back into the DB
        }

        return agreement;  // Return the updated agreement
    }
}

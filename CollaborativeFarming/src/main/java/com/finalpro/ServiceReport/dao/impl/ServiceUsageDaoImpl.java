package com.finalpro.ServiceReport.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.finalpro.ServiceReport.dao.ServiceUsageDao;
import com.finalpro.ServiceReport.dto.ServiceUsageDto;

@Repository
public class ServiceUsageDaoImpl implements ServiceUsageDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<ServiceUsageDto> getAcceptedServiceUsageStats() {
        Session session = sessionFactory.getCurrentSession();

        String hql = "SELECT new com.finalpro.ServiceReport.dto.ServiceUsageDto(s.id, s.name, COUNT(a.agreementId)) " +
                     "FROM com.finalpro.ServiceRequest.model.Agreement a " +
                     "JOIN com.finalpro.ServiceRequest.model.ServiceModel s ON a.serviceId = s.id " +
                     "WHERE a.status = 'accepted' " +
                     "GROUP BY s.id, s.name " +
                     "ORDER BY COUNT(a.agreementId) DESC";

        return session.createQuery(hql, ServiceUsageDto.class).getResultList();
    }
}
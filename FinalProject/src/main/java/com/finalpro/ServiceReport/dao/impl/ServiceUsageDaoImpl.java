package com.finalpro.ServiceReport.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.finalpro.ServiceReport.dao.ServiceUsageDao;
import com.finalpro.ServiceReport.dto.ServiceUsageDto;
import com.finalpro.ServiceRequest.model.*;

@Repository
public class ServiceUsageDaoImpl implements ServiceUsageDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ServiceUsageDto> getAcceptedServiceUsageStats() {
    	String jpql = "SELECT new com.finalpro.ServiceReport.dto.ServiceUsageDto(s.id, s.name, COUNT(a.agreementId)) " +
                "FROM com.finalpro.ServiceRequest.model.Agreement a " +
                "JOIN com.finalpro.ServiceRequest.model.ServiceModel s ON a.serviceId = s.id " +
                "WHERE a.status = 'accepted' " +
                "GROUP BY s.id, s.name " +
                "ORDER BY COUNT(a.agreementId) DESC";


        return entityManager.createQuery(jpql, ServiceUsageDto.class).getResultList();
    }
}

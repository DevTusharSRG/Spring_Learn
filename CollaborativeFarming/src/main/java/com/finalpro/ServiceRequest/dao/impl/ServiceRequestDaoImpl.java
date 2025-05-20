package com.finalpro.ServiceRequest.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.finalpro.ServiceRequest.dao.ServiceRequestDao;
import com.finalpro.ServiceRequest.model.ServiceModel;
import com.finalpro.ServiceRequest.model.ServiceProviderModel;

@Repository
public class ServiceRequestDaoImpl implements ServiceRequestDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Transactional
	public List<ServiceProviderModel> getAllServiceProvider(){
		Session session = sessionFactory.getCurrentSession();
		Query <ServiceProviderModel> query = session.createQuery("from ServiceProviderModel",ServiceProviderModel.class);
		return query.getResultList();
	}
	
	@Transactional
	public List<ServiceModel> getAllServices(){
		Session session = sessionFactory.getCurrentSession();
		Query <ServiceModel> query = session.createQuery("from ServiceModel", ServiceModel.class);
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public List<ServiceProviderModel> getProvidersByServiceId(Long serviceId) {
	    Session session = sessionFactory.getCurrentSession();
	    String hql = "FROM ServiceProviderModel sp WHERE sp.serviceId = :serviceId";
	    Query<ServiceProviderModel> query = session.createQuery(hql, ServiceProviderModel.class);
	    query.setParameter("serviceId", serviceId);
	    return query.getResultList();
	}


	
}
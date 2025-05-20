package com.finalpro.ServiceRequest.dao;

import java.util.List;

import com.finalpro.ServiceRequest.model.ServiceModel;
import com.finalpro.ServiceRequest.model.ServiceProviderModel;


public interface ServiceRequestDao{
	public List<ServiceProviderModel> getAllServiceProvider();
	public List<ServiceModel> getAllServices();
}
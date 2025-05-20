package com.finalpro.ServiceRequest.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalpro.ServiceRequest.dao.ServiceRequestDao;
import com.finalpro.ServiceRequest.dto.AgreementDTO;
import com.finalpro.ServiceRequest.dto.ServiceProviderDTO;
import com.finalpro.ServiceRequest.model.ServiceModel;
import com.finalpro.ServiceRequest.model.ServiceProviderModel;
import com.finalpro.ServiceRequest.service.ServiceRequestService;
import com.finalpro.ServiceRequest.dto.ServicesDto;

@Service
@Transactional
public class ServiceRequestServiceImpl implements ServiceRequestService {

    @Autowired
    private ServiceRequestDao serviceRequestDao;

    @Autowired
    private ModelMapper modelMapper;

    public List<ServiceProviderDTO> getAllServiceProviders() {
        List<ServiceProviderModel> providers = serviceRequestDao.getAllServiceProvider();
        return providers.stream()
                .map(provider -> modelMapper.map(provider, ServiceProviderDTO.class))
                .collect(Collectors.toList());
    }
    
    public List<ServicesDto> getAllServices(){
    	List<ServiceModel> services = serviceRequestDao.getAllServices();
    	return services.stream()
    			.map(service -> modelMapper.map(service, ServicesDto.class))
    			.collect(Collectors.toList());
    }


    
    
}

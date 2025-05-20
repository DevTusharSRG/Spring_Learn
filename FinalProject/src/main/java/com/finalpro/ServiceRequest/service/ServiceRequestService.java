package com.finalpro.ServiceRequest.service;

import java.util.List;

import com.finalpro.ServiceRequest.dto.AgreementDTO;
import com.finalpro.ServiceRequest.dto.ServiceProviderDTO;
import com.finalpro.ServiceRequest.dto.ServicesDto;

public interface ServiceRequestService {
    List<ServiceProviderDTO> getAllServiceProviders();
    public List<ServicesDto> getAllServices();
}

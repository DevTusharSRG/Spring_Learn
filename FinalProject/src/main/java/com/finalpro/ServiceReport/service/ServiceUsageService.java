package com.finalpro.ServiceReport.service;

import java.util.List;

import com.finalpro.ServiceReport.dto.ServiceUsageDto;

public interface ServiceUsageService {
    List<ServiceUsageDto> fetchAcceptedServiceStats();
}

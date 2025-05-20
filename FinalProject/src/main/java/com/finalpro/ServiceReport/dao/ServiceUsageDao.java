package com.finalpro.ServiceReport.dao;

import java.util.List;

import com.finalpro.ServiceReport.dto.ServiceUsageDto;

public interface ServiceUsageDao {
    List<ServiceUsageDto> getAcceptedServiceUsageStats();
}

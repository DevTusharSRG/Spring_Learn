package com.finalpro.ServiceReport.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalpro.ServiceReport.dao.ServiceUsageDao;
import com.finalpro.ServiceReport.dto.ServiceUsageDto;
import com.finalpro.ServiceReport.service.ServiceUsageService;

@Service
public class ServiceUsageServiceImpl implements ServiceUsageService {

    @Autowired
    private ServiceUsageDao serviceUsageDao;

    @Override
    @Transactional
    public List<ServiceUsageDto> fetchAcceptedServiceStats() {
        return serviceUsageDao.getAcceptedServiceUsageStats();
    }
}

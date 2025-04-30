package com.GovernmentSchemes.GovernmentSchemeReport.service.impl;

import com.GovernmentSchemes.GovernmentSchemeReport.dao.ReportDao;
import com.GovernmentSchemes.GovernmentSchemeReport.dto.FarmerSchemeInfoDto;
import com.GovernmentSchemes.GovernmentSchemeReport.service.ReportService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportDao reportDao;

    @Override
    @Transactional
    public List<FarmerSchemeInfoDto> getFarmersWithMultipleSchemes() {
        return reportDao.getFarmersWithMultipleSchemes();
    }
}

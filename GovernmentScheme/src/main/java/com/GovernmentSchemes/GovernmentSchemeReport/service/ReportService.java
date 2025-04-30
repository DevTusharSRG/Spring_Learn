package com.GovernmentSchemes.GovernmentSchemeReport.service;

import com.GovernmentSchemes.GovernmentSchemeReport.dto.FarmerSchemeInfoDto;
import java.util.List;

public interface ReportService {
    List<FarmerSchemeInfoDto> getFarmersWithMultipleSchemes();
}

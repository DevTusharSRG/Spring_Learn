package com.GovernmentSchemes.GovernmentSchemeReport.dao;

import com.GovernmentSchemes.GovernmentSchemeReport.dto.FarmerSchemeInfoDto;
import java.util.List;

public interface ReportDao {
    List<FarmerSchemeInfoDto> getFarmersWithMultipleSchemes();
}

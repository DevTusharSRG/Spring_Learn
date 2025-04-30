package com.GovernmentSchemes.GovernmentSchemes.service;

import com.GovernmentSchemes.GovernmentSchemes.dto.GovernmentSchemeApplicationDTO;
import java.util.List;

public interface GovernmentSchemeApplicationService {
    void apply(GovernmentSchemeApplicationDTO dto);
    List<GovernmentSchemeApplicationDTO> getAllApplications();
    GovernmentSchemeApplicationDTO getApplication(int id);
    boolean updateApplication(GovernmentSchemeApplicationDTO dto);
    boolean deleteApplication(int id);
}

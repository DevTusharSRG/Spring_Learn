package com.GovernmentSchemes.GovernmentSchemes.service;

import com.GovernmentSchemes.GovernmentSchemes.dto.GovernmentSchemeDTO;
import com.GovernmentSchemes.GovernmentSchemes.model.GovernmentScheme;

import java.util.List;

public interface GovernmentSchemeService {
    void createScheme(GovernmentSchemeDTO dto);
    List<GovernmentScheme> getAllSchemes();
    GovernmentScheme getSchemeById(int id);
    boolean updateScheme(int id, GovernmentSchemeDTO dto);
    boolean deleteScheme(int id);
}

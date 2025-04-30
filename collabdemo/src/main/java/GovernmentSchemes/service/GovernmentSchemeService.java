package GovernmentSchemes.service;

import GovernmentSchemes.dto.GovernmentSchemeDTO;
import GovernmentSchemes.model.GovernmentScheme;

import java.util.List;

public interface GovernmentSchemeService {
    void createScheme(GovernmentSchemeDTO dto);
    List<GovernmentScheme> getAllSchemes();
    GovernmentScheme getSchemeById(int id);
    boolean updateScheme(int id, GovernmentSchemeDTO dto);
    boolean deleteScheme(int id);
}

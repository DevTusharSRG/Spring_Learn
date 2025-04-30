package GovernmentSchemes.service.impl;

import GovernmentSchemes.dao.GovernmentSchemeDAO;
import GovernmentSchemes.dto.GovernmentSchemeDTO;
import GovernmentSchemes.model.GovernmentScheme;
import GovernmentSchemes.service.GovernmentSchemeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Service
@Transactional
public class GovernmentSchemeServiceImpl implements GovernmentSchemeService {

    private final GovernmentSchemeDAO schemeDAO;

    @Autowired
    public GovernmentSchemeServiceImpl(GovernmentSchemeDAO schemeDAO) {
        this.schemeDAO = schemeDAO;
    }

    @Override
    public void createScheme(GovernmentSchemeDTO dto) {
        GovernmentScheme scheme = mapToEntity(dto);
        scheme.setCreatedDate(java.time.LocalDateTime.now());
        schemeDAO.save(scheme);
    }

    @Override
    public List<GovernmentScheme> getAllSchemes() {
        return schemeDAO.getAll();
    }

    @Override
    public GovernmentScheme getSchemeById(int id) {
        return schemeDAO.getById(id);
    }

    @Override
    public boolean updateScheme(int id, GovernmentSchemeDTO dto) {
        GovernmentScheme existingScheme = schemeDAO.getById(id);
        if (existingScheme != null) {
            existingScheme.setTitle(dto.getTitle());
            existingScheme.setBenefitAmount(dto.getBenefitAmount()); // assuming dto.getBenefitAmount() is Double
            existingScheme.setStartDate(dto.getStartDate()); 
            existingScheme.setLastDate(dto.getLastDate());
            existingScheme.setDescription(dto.getDescription());
            schemeDAO.update(existingScheme);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteScheme(int id) {
        GovernmentScheme scheme = schemeDAO.getById(id);
        if (scheme != null) {
            schemeDAO.delete(id);
            return true;
        }
        return false;
    }

    private GovernmentScheme mapToEntity(GovernmentSchemeDTO dto) {
        GovernmentScheme scheme = new GovernmentScheme();
        scheme.setTitle(dto.getTitle());
        scheme.setBenefitAmount(dto.getBenefitAmount()); // assuming dto.getBenefitAmount() is Double
        scheme.setStartDate(dto.getStartDate());
        scheme.setLastDate(dto.getLastDate());
        scheme.setDescription(dto.getDescription());
        return scheme;
    }
}

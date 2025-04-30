package GovernmentSchemes.service.impl;

import GovernmentSchemes.dao.GovernmentSchemeApplicationDAO;
import GovernmentSchemes.dto.GovernmentSchemeApplicationDTO;
import GovernmentSchemes.model.GovernmentSchemeApplication;
import GovernmentSchemes.service.GovernmentSchemeApplicationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class GovernmentSchemeApplicationServiceImpl implements GovernmentSchemeApplicationService {

    private final GovernmentSchemeApplicationDAO applicationDAO;

    @Autowired
    public GovernmentSchemeApplicationServiceImpl(GovernmentSchemeApplicationDAO dao) {
        this.applicationDAO = dao;
    }

    @Override
    public void apply(GovernmentSchemeApplicationDTO dto) {
        GovernmentSchemeApplication app = new GovernmentSchemeApplication();
        app.setSchemeId(dto.getSchemeId().intValue());
        app.setFarmerId(dto.getFarmerId().intValue());
        app.setRegisterDate(new Timestamp(System.currentTimeMillis()));
        app.setStatus("Pending");
        applicationDAO.save(app);
    }

    @Override
    public List<GovernmentSchemeApplicationDTO> getAllApplications() {
        return applicationDAO.getAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public GovernmentSchemeApplicationDTO getApplication(int id) {
        GovernmentSchemeApplication app = applicationDAO.getById(id);
        return app != null ? convertToDTO(app) : null;
    }

    @Override
    public boolean updateApplication(GovernmentSchemeApplicationDTO dto) {
        GovernmentSchemeApplication app = applicationDAO.getById(dto.getApplicationId().intValue());
        if (app != null) {
            app.setSchemeId(dto.getSchemeId().intValue());
            app.setFarmerId(dto.getFarmerId().intValue());
            app.setStatus(dto.getStatus());
            applicationDAO.update(app);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteApplication(int id) {
        GovernmentSchemeApplication app = applicationDAO.getById(id);
        if (app != null) {
            applicationDAO.delete(id);
            return true;
        }
        return false;
    }

    private GovernmentSchemeApplicationDTO convertToDTO(GovernmentSchemeApplication app) {
        GovernmentSchemeApplicationDTO dto = new GovernmentSchemeApplicationDTO();
        dto.setApplicationId((long) app.getApplicationId());
        dto.setSchemeId((long) app.getSchemeId());
        dto.setFarmerId((long) app.getFarmerId());
        dto.setRegisterDate(app.getRegisterDate().toLocalDateTime().toLocalDate());
        dto.setStatus(app.getStatus());
        return dto;
    }
}

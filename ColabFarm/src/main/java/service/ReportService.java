package service;

import dao.ReportDao;
import dto.FarmerSchemeInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    private ReportDao reportDao;

    public List<FarmerSchemeInfoDto> getFarmersWithMultipleSchemes() {
        return reportDao.getFarmersWithMultipleSchemes();
    }
}

package GovernmentSchemeReport.service;

import GovernmentSchemeReport.dao.ReportDao;
import GovernmentSchemeReport.dto.FarmerSchemeInfoDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
//
//@Service
//public class ReportService {
//
//    @Autowired
//    private ReportDao reportDao;
//
//    @Autowired
//    private ModelMapper modelMapper;
//
//    @Transactional
//    public List<FarmerSchemeInfoDto> getFarmersWithMultipleSchemes() {
//        List<Integer> farmerIds = reportDao.getFarmerIds();
//
//        return farmerIds.stream().map(farmerId -> {
//            String farmerName = reportDao.getFarmerName(farmerId);
//            List<String> schemeTitles = reportDao.getSchemeTitlesByFarmer(farmerId);
//
//            // Mapping manually + using ModelMapper (if needed)
//            FarmerSchemeInfoDto dto = modelMapper.map(new Object(), FarmerSchemeInfoDto.class);
//            dto.setFarmerId(farmerId);
//            dto.setFarmerName(farmerName);
//            dto.setSchemeNames(schemeTitles);
//            dto.setTotalSchemes((long) schemeTitles.size());
//
//            return dto;
//        }).collect(Collectors.toList());
//    }
//}



@Service
public class ReportService {

    @Autowired
    private ReportDao reportDao;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public List<FarmerSchemeInfoDto> getFarmersWithMultipleSchemes() {
        List<Integer> farmerIds = reportDao.getFarmerIds();

        return farmerIds.stream().map(farmerId -> {
            // Prepare data
            String farmerName = reportDao.getFarmerName(farmerId);
            List<String> schemeTitles = reportDao.getSchemeTitlesByFarmer(farmerId);

            // Step 1: Create a temporary object to map from
            Map<String, Object> tempMap = new HashMap<>();
            tempMap.put("farmerId", farmerId);
            tempMap.put("farmerName", farmerName);

            // Step 2: Use ModelMapper to map partial data
            FarmerSchemeInfoDto dto = modelMapper.map(tempMap, FarmerSchemeInfoDto.class);

            // Step 3: Manually set additional fields
            dto.setSchemeNames(schemeTitles);
            dto.setTotalSchemes((long) schemeTitles.size());

            return dto;
        }).collect(Collectors.toList());
    }
}


package controller;

import dto.FarmerSchemeInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.ReportService;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/farmers-schemes")
    public List<FarmerSchemeInfoDto> getFarmersWithSchemes() {
        return reportService.getFarmersWithMultipleSchemes();
    }
}

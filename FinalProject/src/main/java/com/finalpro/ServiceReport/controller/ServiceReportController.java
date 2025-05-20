package com.finalpro.ServiceReport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finalpro.ServiceReport.dto.ServiceUsageDto;
import com.finalpro.ServiceReport.service.ServiceUsageService;

@RestController
@RequestMapping("/api/services")
public class ServiceReportController {

    @Autowired
    private ServiceUsageService serviceUsageService;

    @GetMapping("/usage-stats")
    public ResponseEntity<List<ServiceUsageDto>> getAcceptedServiceUsageStats() {
        List<ServiceUsageDto> stats = serviceUsageService.fetchAcceptedServiceStats();
        return ResponseEntity.ok(stats);
    }
}

package com.finalpro.ServiceRequest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.finalpro.ServiceRequest.dto.ServiceProviderDTO;
import com.finalpro.ServiceRequest.dto.ServicesDto;
import com.finalpro.ServiceRequest.service.ServiceRequestService;

@RestController
@RequestMapping("/api/service")
public class ServiceRequestController{
	@Autowired
	private ServiceRequestService serviceRequestService;

	@GetMapping("/getProviders")
	public ResponseEntity<List<ServiceProviderDTO>> getAllServiceProvider() {
	    List<ServiceProviderDTO> providers = serviceRequestService.getAllServiceProviders();
	    return ResponseEntity.ok(providers);
	}
	
	@GetMapping("/getServices")
	public ResponseEntity<List<ServicesDto>> getAllServices(){
		List<ServicesDto> services = serviceRequestService.getAllServices();
		return ResponseEntity.ok(services);
	}
	
	@GetMapping("/getProvidersByService")
	public ResponseEntity<List<ServiceProviderDTO>> getServiceProvidersByService(@RequestParam Long serviceId) {
	    List<ServiceProviderDTO> providers = serviceRequestService.getProvidersByServiceId(serviceId);
	    return ResponseEntity.ok(providers);
	}

}


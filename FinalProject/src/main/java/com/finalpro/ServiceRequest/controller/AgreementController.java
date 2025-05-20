package com.finalpro.ServiceRequest.controller;

import com.finalpro.ServiceRequest.dto.AgreementDTO;
import com.finalpro.ServiceRequest.dto.AgreementStatusUpdateDTO;
import com.finalpro.ServiceRequest.dto.ServiceProviderDTO;
import com.finalpro.ServiceRequest.service.AgreementService;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agreements")
public class AgreementController {

    @Autowired
    private AgreementService agreementService;

    
    // Save full agreement
    @PostMapping("/save/application")
    public AgreementDTO createAgreement(@RequestBody AgreementDTO agreementDTO) {
        return agreementService.saveAgreement(agreementDTO);
    }
    
    
    @PutMapping("/status/{id}")
    public ResponseEntity<?> updateAgreementStatus(@PathVariable Long id, @RequestBody @Valid AgreementStatusUpdateDTO statusDTO, BindingResult bindingResult) {

        // Check for validation errors
        if (bindingResult.hasErrors()) {
            StringBuilder errorMsg = new StringBuilder();
            bindingResult.getFieldErrors().forEach(error ->
                    errorMsg.append(error.getField())
                            .append(": ")
                            .append(error.getDefaultMessage())
                            .append("; "));
            return ResponseEntity.badRequest().body("Validation error(s): " + errorMsg.toString());
        }

        // Proceed with update
        agreementService.updateStatus(id, statusDTO);
        return ResponseEntity.ok(statusDTO);
    }


}


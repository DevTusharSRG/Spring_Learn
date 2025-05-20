package com.finalpro.ServiceRequest.service.impl;

import com.finalpro.ServiceRequest.dto.AgreementDTO;
import com.finalpro.ServiceRequest.dto.AgreementStatusUpdateDTO;
import com.finalpro.ServiceRequest.dao.AgreementDAO;
import com.finalpro.ServiceRequest.model.Agreement;
import com.finalpro.ServiceRequest.service.AgreementService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgreementServiceImpl implements AgreementService {

    @Autowired
    private AgreementDAO agreementDAO;

    @Autowired
    private ModelMapper modelMapper;

    // Save new Agreement
    @Override
    public AgreementDTO saveAgreement(AgreementDTO agreementDTO) {
        Agreement agreement = modelMapper.map(agreementDTO, Agreement.class);  // Convert DTO to entity
        Agreement savedAgreement = agreementDAO.save(agreement);  // Save the entity
        return modelMapper.map(savedAgreement, AgreementDTO.class);  // Convert saved entity to DTO
    }

    // Update Agreement Status
    @Override
    public AgreementDTO updateStatus(Long id, AgreementStatusUpdateDTO statusDTO) {
        Agreement updatedAgreement = agreementDAO.updateStatus(id, statusDTO.getStatus());  // Update status
        return modelMapper.map(updatedAgreement, AgreementDTO.class);  // Convert updated entity to DTO
    }
}

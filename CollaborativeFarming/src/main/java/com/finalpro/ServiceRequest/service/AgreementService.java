package com.finalpro.ServiceRequest.service;

import com.finalpro.ServiceRequest.dto.AgreementDTO;
import com.finalpro.ServiceRequest.dto.AgreementStatusUpdateDTO;

public interface AgreementService {
    AgreementDTO saveAgreement(AgreementDTO agreementDTO);
    public AgreementDTO updateStatus(Long id, AgreementStatusUpdateDTO statusDTO);
}

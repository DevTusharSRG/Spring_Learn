package com.finalpro.ServiceRequest.dao;

import com.finalpro.ServiceRequest.model.Agreement;

public interface AgreementDAO {
    Agreement save(Agreement agreement);
    Agreement findById(Long id);
    Agreement updateStatus(Long agreementId, String status);
}


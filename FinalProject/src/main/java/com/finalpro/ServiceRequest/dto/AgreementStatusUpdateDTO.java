package com.finalpro.ServiceRequest.dto;

public class AgreementStatusUpdateDTO {
    private String status;

    public AgreementStatusUpdateDTO() {
    }

    public AgreementStatusUpdateDTO(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

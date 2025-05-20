package com.finalpro.ServiceReport.dto;

public class ServiceUsageDto {
    private Long serviceId;
    private String serviceName;
    private Long totalServices;

    public ServiceUsageDto(Long serviceId, String serviceName, Long totalServices) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.totalServices = totalServices;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Long getTotalServices() {
        return totalServices;
    }

    public void setTotalServices(Long totalServices) {
        this.totalServices = totalServices;
    }
}


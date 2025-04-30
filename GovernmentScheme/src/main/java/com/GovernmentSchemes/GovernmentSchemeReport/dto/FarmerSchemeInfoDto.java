package com.GovernmentSchemes.GovernmentSchemeReport.dto;

import java.util.List;

public class FarmerSchemeInfoDto {
    private int farmerId;
    private String farmerName;
    private long totalSchemes;
    private List<String> schemeNames;

    // Default constructor
    public FarmerSchemeInfoDto() {
    }

    // Getters and Setters
    public int getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(int farmerId) {
        this.farmerId = farmerId;
    }

    public String getFarmerName() {
        return farmerName;
    }

    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
    }

    public long getTotalSchemes() {
        return totalSchemes;
    }

    public void setTotalSchemes(long totalSchemes) {
        this.totalSchemes = totalSchemes;
    }

    public List<String> getSchemeNames() {
        return schemeNames;
    }

    public void setSchemeNames(List<String> schemeNames) {
        this.schemeNames = schemeNames;
    }
}

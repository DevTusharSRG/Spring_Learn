package com.GovernmentSchemes.GovernmentSchemes.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "government_scheme_application")
public class GovernmentSchemeApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id")
    private int applicationId;

    @Column(name = "scheme_id")
    private int schemeId;

    @Column(name = "farmer_id")
    private int farmerId;

    @Column(name = "register_date")
    private Timestamp registerDate;

    @Column(name = "status", length = 20)
    private String status;

    // Getters and Setters
    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public int getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(int schemeId) {
        this.schemeId = schemeId;
    }

    public int getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(int farmerId) {
        this.farmerId = farmerId;
    }

    public Timestamp getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Timestamp registerDate) {
        this.registerDate = registerDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

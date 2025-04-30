package GovernmentSchemes.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class GovernmentSchemeApplicationDTO {

    private Long applicationId;

    @NotNull(message = "Scheme ID is required")
    private Long schemeId;

    @NotNull(message = "Farmer ID is required")
    private Long farmerId;

    private LocalDate registerDate;

    @NotNull(message = "Status is required")
    @Size(min = 2, message = "Status must be at least 2 characters")
    private String status;

    // Getters and Setters

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public Long getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(Long schemeId) {
        this.schemeId = schemeId;
    }

    public Long getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(Long farmerId) {
        this.farmerId = farmerId;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

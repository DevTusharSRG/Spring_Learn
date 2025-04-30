package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "government_scheme_application")
public class GovernmentSchemeApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicationId;

    @ManyToOne
    @JoinColumn(name = "farmer_id")
    private User farmer;

    @ManyToOne
    @JoinColumn(name = "scheme_id")
    private GovernmentScheme scheme;


    @Column(name = "register_date")
    private LocalDateTime registerDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        PENDING, ACCEPTED, REJECTED
    }

    // Getters and Setters

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public GovernmentScheme getScheme() {
        return scheme;
    }

    public void setScheme(GovernmentScheme scheme) {
        this.scheme = scheme;
    }

    public User getFarmerId() {
        return farmer;
    }

    public void setFarmerId(User farmerId) {
        this.farmer = farmer;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

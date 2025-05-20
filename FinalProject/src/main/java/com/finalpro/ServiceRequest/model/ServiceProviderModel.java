package com.finalpro.ServiceRequest.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="service_provider")
public class ServiceProviderModel{
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="id")
	private long serviceProviderId;
	
	@Column(name = "service_id")
    private Long serviceId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "price", precision = 10, scale = 2, nullable = false)
    private BigDecimal price;

    @Column(name = "area", precision = 10, scale = 2, nullable = false)
    private BigDecimal area;

    @Column(name = "available", nullable = false)
    private Boolean available = true;

    @Column(name = "village", length = 100)
    private String village;

    @Column(name = "taluka", length = 100)
    private String taluka;

    @Column(name = "district", length = 100)
    private String district;

    @Column(name = "state", length = 100)
    private String state;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "service_type", length = 100)
    private String serviceType;

    @Column(name = "create_date")
    private Timestamp createDate;

}
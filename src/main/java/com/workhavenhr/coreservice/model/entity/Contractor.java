package com.workhavenhr.coreservice.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Entity
@Table (name = "contractors")
@PrimaryKeyJoinColumn(name = "user_id")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Contractor extends User {

    @NotBlank(message = "Daily rate cannot be empty")
    @Column(name = "daily_rate", nullable = false)
    private Double dailyRate;

    @NotNull(message = "Contract duration days is required")
    @Column(name = "contract_duration_days", nullable = false)
    private Integer contractDurationDays;

}

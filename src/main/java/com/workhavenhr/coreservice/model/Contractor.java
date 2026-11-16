package com.workhavenhr.coreservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.experimental.SuperBuilder;
import lombok.*;


@Entity
@Table (name = "contractors")
@PrimaryKeyJoinColumn(name = "user_id")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Contractor extends User {

    @Column(name = "daily_rate", nullable = false)
    private Double dailyRate;

    @Column(name = "contract_duration_days", nullable = false)
    private Integer contractDurationDays;

}

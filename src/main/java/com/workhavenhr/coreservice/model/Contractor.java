package com.workhavenhr.coreservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "contractors")
@Getter
@Setter
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id")
public class Contractor extends User {

    @Column(name = "daily_rate", nullable = false)
    private Double dailyRate;

    @Column(name = "contract_duration_days", nullable = false)
    private Integer contractDurationDays;
}

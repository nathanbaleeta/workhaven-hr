package com.workhavenhr.coreservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "full_time_employees")
@Getter
@Setter
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id")
public class FullTimeEmployee extends User {

    @Column(name = "ssn", unique = true)
    private Long ssn;
}

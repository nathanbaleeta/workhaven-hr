package com.workhavenhr.coreservice.repository;

import com.workhavenhr.coreservice.model.FullTimeEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FullTimeEmployeeRepository extends JpaRepository <FullTimeEmployee, Long> {
}

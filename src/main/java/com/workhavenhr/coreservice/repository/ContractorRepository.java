package com.workhavenhr.coreservice.repository;

import com.workhavenhr.coreservice.model.Contractor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractorRepository extends JpaRepository <Contractor, Long> {
}

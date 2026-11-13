package com.workhavenhr.coreservice.service;

import com.workhavenhr.coreservice.model.Contractor;

import java.util.List;
import java.util.Optional;

public interface ContractorService {
    List<Contractor> getAllContractors();

    Optional<Contractor> getContractorById(Long contractorId);

    Contractor createContractor(Contractor contractor);

    //Optional<Contractor> updateContractor(Long contractorId, Contractor contractorDetails);

    //boolean deleteContractor(Long contractorId);

}

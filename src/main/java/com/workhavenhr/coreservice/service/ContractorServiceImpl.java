package com.workhavenhr.coreservice.service;

import com.workhavenhr.coreservice.model.Contractor;
import com.workhavenhr.coreservice.repository.ContractorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractorServiceImpl implements ContractorService {
    @Autowired
    private ContractorRepository contractorRepository;

    @Override
    public List<Contractor> getAllContractors() {
        return contractorRepository.findAll();
    }

    @Override
    public Optional<Contractor> getContractorById(Long contractorId) {
        return contractorRepository.findById(contractorId);
    }

    @Override
    public Contractor createContractor(Contractor contractor) {
        return contractorRepository.save(contractor);
    }

}

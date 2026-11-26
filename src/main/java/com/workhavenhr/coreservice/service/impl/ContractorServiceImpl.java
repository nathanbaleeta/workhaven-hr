package com.workhavenhr.coreservice.service.impl;

import com.workhavenhr.coreservice.model.Contractor;
import com.workhavenhr.coreservice.repository.ContractorRepository;
import com.workhavenhr.coreservice.service.ContractorService;
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

    @Override
    public Optional<Contractor> updateContractor(Long contractorId, Contractor contractorDetails) {
        Optional<Contractor> optionalContractor = contractorRepository.findById(contractorId);
        if (optionalContractor.isPresent()) {
            Contractor contractor = optionalContractor.get();

            // User-generic fields
            contractor.setFirstName(contractorDetails.getFirstName());
            contractor.setLastName(contractorDetails.getLastName());
            contractor.setEmail(contractorDetails.getEmail());
            contractor.setDob(contractorDetails.getDob());
            contractor.setPhoneNumber(contractorDetails.getPhoneNumber());
            contractor.setNin(contractorDetails.getNin());

            // Contractor-specific fields
            contractor.setDailyRate(contractorDetails.getDailyRate());
            contractor.setContractDurationDays(contractorDetails.getContractDurationDays());
            return Optional.of(contractorRepository.save(contractor));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public boolean deleteContractor(Long contractorId) {
        Optional<Contractor> optionalContractor = contractorRepository.findById(contractorId);
        if (optionalContractor.isPresent()) {
            contractorRepository.delete(optionalContractor.get());
            return true;
        } else {
            return false;
        }
    }

}

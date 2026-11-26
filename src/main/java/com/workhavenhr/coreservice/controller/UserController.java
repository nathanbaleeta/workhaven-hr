package com.workhavenhr.coreservice.controller;

import com.workhavenhr.coreservice.model.entity.Contractor;
import com.workhavenhr.coreservice.model.entity.FullTimeEmployee;
import com.workhavenhr.coreservice.model.entity.User;
import com.workhavenhr.coreservice.repository.ContractorRepository;
import com.workhavenhr.coreservice.repository.FullTimeEmployeeRepository;
import com.workhavenhr.coreservice.repository.UserRepository;
import com.workhavenhr.coreservice.service.ContractorService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserController {

    private final UserRepository userRepository;
    private final FullTimeEmployeeRepository fullTimeEmployeeRepository;
    private ContractorRepository contractorRepository;

    private final ContractorService contractorService;

    // Get all employees (Polymorphic: returns Full-Time & Contractors)
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    @GetMapping("/full-time")
    public List<FullTimeEmployee> getAllFullTimeEmployees() {
        return fullTimeEmployeeRepository.findAll();
    }


    @GetMapping("/contractors")
    public List<Contractor> getAllContractors() {
        return contractorService.getAllContractors();
    }

    // Add a Full-Time Employee
    @PostMapping("/full-time")
    public ResponseEntity<FullTimeEmployee> createFullTimeEmployee(@RequestBody FullTimeEmployee fullTimeEmployee) {
        FullTimeEmployee saved = fullTimeEmployeeRepository.save(fullTimeEmployee);
        return ResponseEntity.ok(saved);
    }

    // Add a Contractor
    @PostMapping("/contractors")
    public ResponseEntity<Contractor> createContractor(@Valid @RequestBody Contractor contractor) {
        Contractor saved = contractorRepository.save(contractor);
        return ResponseEntity.ok(saved);
    }

    // Update a Contractor
    @PutMapping("/{id}")
    public ResponseEntity<Contractor> updateContractor(@PathVariable(value = "id") Long contractorId,
                                                    @Valid @RequestBody Contractor contractorDetails) {
        Optional<Contractor> optionalContractor = contractorService.updateContractor(contractorId, contractorDetails);
        if (optionalContractor.isPresent()) {
            return ResponseEntity.ok(optionalContractor.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a Contractor
    @DeleteMapping("/{id}")
    public String deleteContractor(@PathVariable(value = "id") Long contractorId) {
        boolean deleted = contractorService.deleteContractor(contractorId);
        if (deleted) {
            return "Contractor deleted successfully.";
        } else {
            return "Contractor not found or could not be deleted.";
        }
    }
}

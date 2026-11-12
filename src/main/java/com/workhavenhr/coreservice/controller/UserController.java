package com.workhavenhr.coreservice.controller;

import com.workhavenhr.coreservice.model.Contractor;
import com.workhavenhr.coreservice.model.FullTimeEmployee;
import com.workhavenhr.coreservice.model.User;
import com.workhavenhr.coreservice.repository.ContractorRepository;
import com.workhavenhr.coreservice.repository.FullTimeEmployeeRepository;
import com.workhavenhr.coreservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final FullTimeEmployeeRepository fullTimeEmployeeRepository;
    private final ContractorRepository contractorRepository;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/fulltime")
    public List<FullTimeEmployee> getAllFullTimeEmployees() {
        return fullTimeEmployeeRepository.findAll();
    }

    @GetMapping("/contractors")
    public List<Contractor> getAllContractors() {
        return contractorRepository.findAll();
    }

    @PostMapping("/fulltime")
    public ResponseEntity<FullTimeEmployee> createFullTimeEmployee(@RequestBody FullTimeEmployee fullTimeEmployee) {
        FullTimeEmployee saved = fullTimeEmployeeRepository.save(fullTimeEmployee);
        return ResponseEntity.ok(saved);
    }

    @PostMapping("/contractors")
    public ResponseEntity<Contractor> createContractor(@RequestBody Contractor contractor) {
        Contractor saved = contractorRepository.save(contractor);
        return ResponseEntity.ok(saved);
    }
}

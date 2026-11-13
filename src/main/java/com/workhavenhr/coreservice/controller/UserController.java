package com.workhavenhr.coreservice.controller;

import com.workhavenhr.coreservice.model.Contractor;
import com.workhavenhr.coreservice.model.FullTimeEmployee;
import com.workhavenhr.coreservice.model.User;
import com.workhavenhr.coreservice.repository.ContractorRepository;
import com.workhavenhr.coreservice.repository.FullTimeEmployeeRepository;
import com.workhavenhr.coreservice.repository.UserRepository;
import com.workhavenhr.coreservice.service.ContractorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserController {

    private final UserRepository userRepository;
    private final FullTimeEmployeeRepository fullTimeEmployeeRepository;

    private final ContractorService contractorService;

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

    @PostMapping("/full-time")
    public ResponseEntity<FullTimeEmployee> createFullTimeEmployee(@RequestBody FullTimeEmployee fullTimeEmployee) {
        FullTimeEmployee saved = fullTimeEmployeeRepository.save(fullTimeEmployee);
        return ResponseEntity.ok(saved);
    }

    /*
    @PostMapping("/contractors")
    public ResponseEntity<Contractor> createContractor(@RequestBody Contractor contractor) {
        Contractor saved = contractorRepository.save(contractor);
        return ResponseEntity.ok(saved);
    }*/
}

package com.workhavenhr.coreservice.service;

import com.workhavenhr.coreservice.model.Contractor;
import com.workhavenhr.coreservice.repository.ContractorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ContractorServiceImplTest {

    @Mock
    private ContractorRepository contractorRepository;

    @InjectMocks
    private ContractorServiceImpl contractorServiceImpl;

    private Contractor contractor;

    @BeforeEach
    void setUp() {
        contractor = new Contractor();
        contractor.setId(1L);

        // User-generic fields
        contractor.setFirstName("Jane");
        contractor.setLastName("Smith");
        contractor.setEmail("jane.smith@example.com");
        contractor.setDob(LocalDate.of(1990, 5, 15));
        contractor.setPhoneNumber("+256700000000");
        contractor.setNin("CM90001234ABCD");
        contractor.setPassword("securePassword123");

        // Contractor-specific fields
        contractor.setDailyRate(100.0);
        contractor.setContractDurationDays(60);
    }

    // ---------------------------------------- Test 1 -----------------------------------------------------

    @Test
    void createContractor_Success() {
        // Arrange
        when(contractorRepository.save(contractor)).thenReturn(contractor);

        // Act
        Contractor savedContractor = contractorServiceImpl.createContractor(contractor);

        // Assert
        assertNotNull(savedContractor);
        assertEquals("Jane", savedContractor.getFirstName());
        assertEquals("jane.smith@example.com", savedContractor.getEmail());
        assertEquals(100.0, savedContractor.getDailyRate());
        assertEquals(60, savedContractor.getContractDurationDays());

        // Verify interactions
        verify(contractorRepository, times(1)).save(contractor); // Optional but recommended
    }

    // ---------------------------------------- Test 2 -----------------------------------------------------
    @Test
    void getContractorById_Success() {
        // Arrange
        when(contractorRepository.findById(1L)).thenReturn(Optional.of(contractor));

        // Act
        Optional<Contractor> foundContractor = contractorServiceImpl.getContractorById(1L);

        // Assert
        assertNotNull(foundContractor);
        assertEquals(1L, foundContractor.get().getId());

        // Verify interactions
        verify(contractorRepository, times(1)).findById(1L);
    }

    // ---------------------------------------- Test 3 -----------------------------------------------------
    @Test
    void getAllContractors_Success() {
        Contractor contractor1 = new Contractor();
        contractor1.setId(1L);

        // User-generic fields
        contractor1.setFirstName("Tom");
        contractor1.setLastName("Justin");
        contractor1.setEmail("tom.justin@example.com");
        contractor1.setDob(LocalDate.of(1990, 5, 15));
        contractor1.setPhoneNumber("+256712345678");
        contractor1.setNin("CM90001234ABCF");
        contractor1.setPassword("securePassword123");

        // Contractor-specific fields
        contractor1.setDailyRate(100.0);
        contractor1.setContractDurationDays(30);

        // Arrange
        when(contractorRepository.findAll()).thenReturn(List.of(contractor, contractor1));

        // Act
        List<Contractor> contractors = contractorServiceImpl.getAllContractors();

        // Assert
        assertEquals(2, contractors.size());

        // Verify interactions
        verify(contractorRepository, times(1)).findAll();
    }

}

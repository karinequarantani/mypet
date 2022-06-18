package com.mypet.application.controller;

import com.mypet.application.model.PetMedications;
import com.mypet.application.model.dto.PetMedicationsDTO;
import com.mypet.application.model.dto.PetMedicationsResponseDTO;
import com.mypet.application.service.PetMedicationsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@Validated
@RestController
@RequestMapping("/pet-medication")
public class PetMedicationsController {

    private final PetMedicationsService petMedicationsService;

    public PetMedicationsController(PetMedicationsService petMedicationsService) {
        this.petMedicationsService = petMedicationsService;
    }

    @PutMapping
    public ResponseEntity<PetMedicationsResponseDTO> insert(@Valid @RequestBody PetMedicationsDTO petMedicationsDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(petMedicationsService.insert(petMedicationsDTO));
    }
}

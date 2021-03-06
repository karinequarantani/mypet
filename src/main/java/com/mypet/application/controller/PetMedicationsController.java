package com.mypet.application.controller;

import com.mypet.application.model.dto.PetMedicationsDTO;
import com.mypet.application.model.dto.PetMedicationsResponseDTO;
import com.mypet.application.model.dto.PetMedicationsUpdateDTO;
import com.mypet.application.service.PetMedicationsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Validated
@RestController
@CrossOrigin
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

    @GetMapping("/{petId}")
    public Page<PetMedicationsResponseDTO> findByPetId(@PathVariable String petId, Pageable pageable){
        return petMedicationsService.findByPetId(petId, pageable);
    }

    @PatchMapping("/{petMedicationId}")
    public PetMedicationsResponseDTO update(@RequestBody PetMedicationsUpdateDTO petMedicationsDTO, @PathVariable String petMedicationId){
        return petMedicationsService.update(petMedicationsDTO, petMedicationId);
    }

    @DeleteMapping("/{petMedicationId}")
    public ResponseEntity<Void> delete(@PathVariable String petMedicationId){
        petMedicationsService.delete(petMedicationId);
        return ResponseEntity.noContent().build();
    }
}

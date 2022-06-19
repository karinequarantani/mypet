package com.mypet.application.controller;

import com.mypet.application.model.dto.PetVaccinesDTO;
import com.mypet.application.model.dto.PetVaccinesResponseDTO;
import com.mypet.application.model.dto.PetVaccinesUpdateDTO;
import com.mypet.application.service.PetVaccinesService;
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
@RequestMapping("/pet-vaccine")
public class PetVaccinesController {

    private final PetVaccinesService petVaccinesService;

    public PetVaccinesController(PetVaccinesService petVaccinesService) {
        this.petVaccinesService = petVaccinesService;
    }

    @PutMapping
    public ResponseEntity<PetVaccinesResponseDTO> insert(@Valid @RequestBody PetVaccinesDTO petVaccinesDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(petVaccinesService.insert(petVaccinesDTO));
    }

    @GetMapping("/{petId}")
    public Page<PetVaccinesResponseDTO> findByPetId(@PathVariable String petId, Pageable pageable){
        return petVaccinesService.findByPetId(petId, pageable);
    }

    @PatchMapping("/{petVaccineId}")
    public PetVaccinesResponseDTO update(@RequestBody PetVaccinesUpdateDTO petVaccinesUpdateDTO, @PathVariable String petVaccineId){
        return petVaccinesService.update(petVaccinesUpdateDTO, petVaccineId);
    }

    @DeleteMapping("/{petVaccineId}")
    public ResponseEntity<Void> delete(@PathVariable String petVaccineId){
        petVaccinesService.delete(petVaccineId);
        return ResponseEntity.noContent().build();
    }
}

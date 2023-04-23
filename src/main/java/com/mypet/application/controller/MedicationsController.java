package com.mypet.application.controller;

import com.mypet.application.model.Medications;
import com.mypet.application.model.dto.MedicationsDTO;
import com.mypet.application.model.dto.MedicationsResponseDTO;
import com.mypet.application.model.dto.MedicationsUpdateDTO;
import com.mypet.application.service.MedicationsService;
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
@RequestMapping("/medications")
public class MedicationsController {

    private final MedicationsService medicationsService;

    public MedicationsController(MedicationsService medicationsService) {
        this.medicationsService = medicationsService;
    }

    @PostMapping
    public ResponseEntity<Medications> insert(@Valid @RequestBody MedicationsDTO medicationsDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(medicationsService.insert(medicationsDTO));
    }

    @GetMapping("/{petId}")
    public Page<MedicationsResponseDTO> findByPetId(@PathVariable String petId, Pageable pageable){
        return medicationsService.findByPetId(petId, pageable);
    }

    @PatchMapping("/{medicationsId}")
    public MedicationsResponseDTO update(@RequestBody MedicationsUpdateDTO medicationsUpdateDTO, @PathVariable String medicationsId){
        return medicationsService.update(medicationsUpdateDTO, medicationsId);
    }

    @DeleteMapping("/{medicationsId}")
    public ResponseEntity<Void> delete(@PathVariable String medicationsId){
        medicationsService.delete(medicationsId);
        return ResponseEntity.noContent().build();
    }

}

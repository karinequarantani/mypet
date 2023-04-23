package com.mypet.application.controller;

import com.mypet.application.model.Vaccines;
import com.mypet.application.model.dto.VaccinesDTO;
import com.mypet.application.model.dto.VaccinesResponseDTO;
import com.mypet.application.model.dto.VaccinesUpdateDTO;
import com.mypet.application.service.VaccinesService;
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
@RequestMapping("/vaccines")
public class VaccinesController {

    private final VaccinesService vaccinesService;

    public VaccinesController(VaccinesService vaccinesService) {
        this.vaccinesService = vaccinesService;
    }

    @PostMapping
    public ResponseEntity<Vaccines> insert(@Valid @RequestBody VaccinesDTO vaccinesDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(vaccinesService.insert(vaccinesDTO));
    }

    @GetMapping("/{petId}")
    public Page<VaccinesResponseDTO> findByPetId(@PathVariable String petId, Pageable pageable){
        return vaccinesService.findByPetId(petId, pageable);
    }

    @PatchMapping("/{vaccineId}")
    public VaccinesResponseDTO update(@RequestBody VaccinesUpdateDTO vaccinesUpdateDTO, @PathVariable String vaccineId){
        return vaccinesService.update(vaccinesUpdateDTO, vaccineId);
    }

    @DeleteMapping("/{vaccineId}")
    public ResponseEntity<Void> delete(@PathVariable String petVaccineId){
        vaccinesService.delete(petVaccineId);
        return ResponseEntity.noContent().build();
    }
}

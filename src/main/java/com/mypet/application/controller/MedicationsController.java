package com.mypet.application.controller;

import com.mypet.application.model.Medications;
import com.mypet.application.model.dto.MedicationsDTO;
import com.mypet.application.model.dto.MedicationsResponseDTO;
import com.mypet.application.service.MedicationsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Validated
@RestController
@RequestMapping("/medications")
public class MedicationsController {

    private final MedicationsService medicationsService;

    public MedicationsController(MedicationsService medicationsService) {
        this.medicationsService = medicationsService;
    }

    @PutMapping
    public Medications insert(@Valid @RequestBody MedicationsDTO medicationsDTO){
        return medicationsService.insert(medicationsDTO);
    }

    @GetMapping
    public Page<MedicationsResponseDTO> findAll(Pageable pageable){
        return medicationsService.findAll(pageable);
    }
}

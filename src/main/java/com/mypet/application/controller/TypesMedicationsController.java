package com.mypet.application.controller;

import com.mypet.application.model.TypesMedications;
import com.mypet.application.model.dto.TypesMedicationsDTO;
import com.mypet.application.service.TypesMedicationsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@Validated
@RestController
@RequestMapping("/types-medications")
public class TypesMedicationsController {

    private final TypesMedicationsService typesMedicationsService;

    public TypesMedicationsController(TypesMedicationsService typesMedicationsService) {
        this.typesMedicationsService = typesMedicationsService;
    }

    @PutMapping
    public TypesMedications insert(@Valid @RequestBody TypesMedicationsDTO typesMedicationsDTO) {
        return typesMedicationsService.insert(typesMedicationsDTO);
    }
}

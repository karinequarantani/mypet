package com.mypet.application.controller;

import com.mypet.application.model.TypesMedications;
import com.mypet.application.model.dto.TypesMedicationsDTO;
import com.mypet.application.service.TypesMedicationsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping
    public List<TypesMedications> findAll(){
        return typesMedicationsService.findAll();
    }
}

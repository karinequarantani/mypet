package com.mypet.application.controller;

import com.mypet.application.model.TypesMedications;
import com.mypet.application.model.dto.TypesMedicationsDTO;
import com.mypet.application.service.TypesMedicationsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Validated
@RestController
@CrossOrigin
@RequestMapping("/types-medications")
public class TypesMedicationsController {

    private final TypesMedicationsService typesMedicationsService;

    public TypesMedicationsController(TypesMedicationsService typesMedicationsService) {
        this.typesMedicationsService = typesMedicationsService;
    }

    @PutMapping
    public ResponseEntity<TypesMedications> insert(@Valid @RequestBody TypesMedicationsDTO typesMedicationsDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(typesMedicationsService.insert(typesMedicationsDTO));
    }

    @GetMapping
    public List<TypesMedications> findAll(){
        return typesMedicationsService.findAll();
    }
}

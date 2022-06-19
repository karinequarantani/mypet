package com.mypet.application.controller;

import com.mypet.application.model.Weight;
import com.mypet.application.model.dto.WeightDTO;
import com.mypet.application.service.WeightService;
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
@RequestMapping("/weight")
public class WeightController {

    private final WeightService weightService;

    public WeightController(WeightService weightService) {
        this.weightService = weightService;
    }

    @PutMapping
    public ResponseEntity<Weight> insert(@Valid @RequestBody WeightDTO weightDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(weightService.insert(weightDTO));
    }

    @GetMapping("/{petId}")
    public Page<Weight> findByPetId(@PathVariable String petId, Pageable pageable){
        return weightService.findByPetId(petId, pageable);
    }
}

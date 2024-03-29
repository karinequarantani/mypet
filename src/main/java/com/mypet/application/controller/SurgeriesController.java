package com.mypet.application.controller;

import com.mypet.application.model.Surgeries;
import com.mypet.application.model.dto.SurgeriesDTO;
import com.mypet.application.model.dto.SurgeriesUpdateDTO;
import com.mypet.application.service.SurgeriesService;
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
@RequestMapping("/surgeries")
public class SurgeriesController {

    private final SurgeriesService surgeriesService;

    public SurgeriesController(SurgeriesService surgeriesService) {
        this.surgeriesService = surgeriesService;
    }

    @PostMapping
    public ResponseEntity<Surgeries> insert(@Valid @RequestBody SurgeriesDTO surgeriesDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(surgeriesService.insert(surgeriesDTO));
    }

    @GetMapping("/{petId}")
    public Page<Surgeries> findByPetId(@PathVariable String petId, Pageable pageable){
        return surgeriesService.findByPetId(petId, pageable);
    }

    @PatchMapping("/{surgeryId}")
    public Surgeries update(@RequestBody SurgeriesUpdateDTO surgeriesUpdateDTO, @PathVariable String surgeryId){
        return surgeriesService.update(surgeriesUpdateDTO, surgeryId);
    }

    @DeleteMapping("/{surgeryId}")
    public ResponseEntity<Void> delete(@PathVariable String surgeryId){
        surgeriesService.delete(surgeryId);
        return ResponseEntity.noContent().build();
    }
}

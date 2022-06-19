package com.mypet.application.controller;

import com.mypet.application.model.Laboratories;
import com.mypet.application.model.dto.LaboratoriesDTO;
import com.mypet.application.service.LaboratoriesService;
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
@RequestMapping("/laboratories")
public class LaboratoriesController {

    private final LaboratoriesService laboratoriesService;

    public LaboratoriesController(LaboratoriesService laboratoriesService) {
        this.laboratoriesService = laboratoriesService;
    }


    @PutMapping
    public ResponseEntity<Laboratories> insert(@Valid @RequestBody LaboratoriesDTO laboratoriesDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(laboratoriesService.insert(laboratoriesDTO));
    }

    @GetMapping
    public List<Laboratories> findAll(){
        return laboratoriesService.findAll();
    }
}

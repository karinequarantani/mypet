package com.mypet.application.controller;

import com.mypet.application.model.Laboratories;
import com.mypet.application.model.dto.LaboratoriesDTO;
import com.mypet.application.service.LaboratoriesService;
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
@RequestMapping("/laboratories")
public class LaboratoriesController {

    private final LaboratoriesService laboratoriesService;

    public LaboratoriesController(LaboratoriesService laboratoriesService) {
        this.laboratoriesService = laboratoriesService;
    }


    @PutMapping
    public Laboratories insert(@Valid @RequestBody LaboratoriesDTO laboratoriesDTO){
        return laboratoriesService.insert(laboratoriesDTO);
    }
}

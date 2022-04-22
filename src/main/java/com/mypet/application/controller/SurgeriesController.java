package com.mypet.application.controller;

import com.mypet.application.model.Surgeries;
import com.mypet.application.model.dto.SurgeriesDTO;
import com.mypet.application.service.SurgeriesService;
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
@RequestMapping("/surgeries")
public class SurgeriesController {

    private final SurgeriesService surgeriesService;

    public SurgeriesController(SurgeriesService surgeriesService) {
        this.surgeriesService = surgeriesService;
    }

    @PutMapping
    public Surgeries insert(@Valid @RequestBody SurgeriesDTO surgeriesDTO){
        return surgeriesService.insert(surgeriesDTO);
    }
}

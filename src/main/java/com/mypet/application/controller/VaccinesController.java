package com.mypet.application.controller;

import com.mypet.application.model.Vaccines;
import com.mypet.application.model.dto.VaccinesDTO;
import com.mypet.application.service.VaccinesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/vaccines")
public class VaccinesController {

    protected final VaccinesService vaccinesService;


    public VaccinesController(VaccinesService vaccinesService) {
        this.vaccinesService = vaccinesService;
    }

    @PutMapping
    public Vaccines inserirVacina(@RequestBody VaccinesDTO vaccines){
        return vaccinesService.insert(vaccines);
    }
}

package com.mypet.application.controller;

import com.mypet.application.model.Vaccines;
import com.mypet.application.model.dto.VaccinesDTO;
import com.mypet.application.service.VaccinesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Validated
@RestController
@RequestMapping("/vaccines")
public class VaccinesController {

    protected final VaccinesService vaccinesService;


    public VaccinesController(VaccinesService vaccinesService) {
        this.vaccinesService = vaccinesService;
    }

    @PutMapping
    public Vaccines inserirVacina(@Valid @RequestBody VaccinesDTO vaccines){
        return vaccinesService.insert(vaccines);
    }

    @GetMapping
    public List<Vaccines> findAll(){
        return vaccinesService.findAll();
    }
}

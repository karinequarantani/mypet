package com.mypet.application.controller;

import com.mypet.application.model.Surgeries;
import com.mypet.application.model.dto.SurgeriesDTO;
import com.mypet.application.model.dto.SurgeriesUpdateDTO;
import com.mypet.application.service.SurgeriesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping
    public List<Surgeries> findAll(){
        return surgeriesService.findAll();
    }

    @PatchMapping("/{surgeryId}")
    public Surgeries update(@RequestBody SurgeriesUpdateDTO surgeriesUpdateDTO, @PathVariable String surgeryId){
        return surgeriesService.update(surgeriesUpdateDTO, surgeryId);
    }

    @DeleteMapping("/{surgeryId}")
    public void delete(@PathVariable String surgeryId){
        surgeriesService.delete(surgeryId);
    }
}

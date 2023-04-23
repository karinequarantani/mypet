package com.mypet.application.controller;

import com.mypet.application.model.Tutor;
import com.mypet.application.model.dto.TutorDTO;
import com.mypet.application.service.TutorService;
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
@RequestMapping("/tutor")
public class TutorController {

    private final TutorService tutorService;

    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    @PostMapping
    public ResponseEntity<Tutor> insert(@Valid @RequestBody TutorDTO tutorDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(tutorService.insert(tutorDTO));
    }

    @PatchMapping("/{tutorId}")
    public Tutor update(@RequestBody TutorDTO tutorDTO, @PathVariable String tutorId){
        return tutorService.update(tutorDTO, tutorId);
    }

    @GetMapping
    public List<Tutor> findAll(){
        return tutorService.findAll();
    }

    @GetMapping("/{tutorId}")
    public Tutor findById(@PathVariable String tutorId){
        return tutorService.findById(tutorId);
    }

    @DeleteMapping("/{tutorId}")
    public ResponseEntity<Void> delete(@PathVariable String tutorId){
        tutorService.delete(tutorId);
        return ResponseEntity.noContent().build();
    }
}

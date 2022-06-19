package com.mypet.application.controller;

import com.mypet.application.model.Pet;
import com.mypet.application.model.dto.PetDTO;
import com.mypet.application.service.PetService;
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
@RequestMapping("/pets")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PutMapping
    public ResponseEntity<Pet> insert(@Valid @RequestBody PetDTO petDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(petService.insert(petDTO));
    }

    @GetMapping("/{tutorId}")
    public Page<Pet> findAllByTutorId(@PathVariable String tutorId, Pageable pageable){
        return petService.findAllByTutorId(tutorId, pageable);
    }

    @PatchMapping("/{petId}")
    public Pet update(@RequestBody PetDTO petDTO, @PathVariable String petId){
        return petService.update(petDTO, petId);
    }

    @DeleteMapping("/{petId}")
    public ResponseEntity<Void> delete(@PathVariable String petId){
        petService.delete(petId);
        return ResponseEntity.noContent().build();
    }
}

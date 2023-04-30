package com.mypet.application.controller;

import com.mypet.application.model.WalkControl;
import com.mypet.application.model.dto.WalkDTO;
import com.mypet.application.model.dto.WalkResponseDTO;
import com.mypet.application.model.dto.WalkUpdateDTO;
import com.mypet.application.service.WalkService;
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
@RequestMapping("/walk")
public class WalkController {

    private final WalkService walkService;

    public WalkController(WalkService walkService) {
        this.walkService = walkService;
    }

    @PostMapping
    public ResponseEntity<WalkControl> insert(@Valid @RequestBody WalkDTO walkDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(walkService.insert(walkDTO));
    }

    @GetMapping("/{petId}")
    public Page<WalkControl> findByPetId(@PathVariable String petId, Pageable pageable){
        return walkService.findByPetId(petId, pageable);
    }

    @PatchMapping("/{walkId}")
    public WalkResponseDTO update(@RequestBody WalkUpdateDTO walkUpdateDTO, @PathVariable String walkId){
        return walkService.update(walkUpdateDTO, walkId);
    }

    @DeleteMapping("/{walkId}")
    public ResponseEntity<Void> delete(@PathVariable String walkId){
        walkService.delete(walkId);
        return ResponseEntity.noContent().build();
    }
}

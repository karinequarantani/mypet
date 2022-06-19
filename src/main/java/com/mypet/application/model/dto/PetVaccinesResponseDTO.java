package com.mypet.application.model.dto;

import com.mypet.application.model.PetMedications;
import com.mypet.application.model.PetVaccines;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PetVaccinesResponseDTO {

    private String id;
    private LocalDate applicationDate;
    private LocalDate nextDate;
    private String description;

    private PetDTO pet;
    private VaccinesDTO vaccine;

    public PetVaccinesResponseDTO(PetVaccines petVaccines){
        this.id = petVaccines.getId();
        this.applicationDate = petVaccines.getApplicationDate();
        this.nextDate = petVaccines.getNextDate();
        this.description = petVaccines.getDescription();
        this.pet = new PetDTO(petVaccines.getPet());
        this.vaccine = new VaccinesDTO(petVaccines.getVaccine());
    }
}

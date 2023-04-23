package com.mypet.application.model.dto;

import com.mypet.application.model.Vaccines;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VaccinesResponseDTO {

    private String id;
    private String name;
    private LocalDate applicationDate;
    private LocalDate nextDate;
    private PetDTO pet;

    public VaccinesResponseDTO(Vaccines vaccines){
        this.id = vaccines.getId();
        this.applicationDate = vaccines.getApplicationDate();
        this.nextDate = vaccines.getNextDate();
        this.name = vaccines.getName();
        this.pet = new PetDTO(vaccines.getPet());
    }
}

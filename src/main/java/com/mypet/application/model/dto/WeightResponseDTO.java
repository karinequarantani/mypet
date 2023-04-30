package com.mypet.application.model.dto;

import com.mypet.application.model.Weight;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WeightResponseDTO {

    private String id;
    private Double weight;
    private LocalDate date;
    private PetDTO pet;

    public WeightResponseDTO(Weight weight){
        this.id = weight.getId();
        this.weight = weight.getWeight();
        this.date = weight.getDate();
        this.pet = new PetDTO(weight.getPet());
    }
}

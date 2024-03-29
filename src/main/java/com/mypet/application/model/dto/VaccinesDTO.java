package com.mypet.application.model.dto;

import com.mypet.application.model.Pet;
import com.mypet.application.model.Vaccines;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VaccinesDTO {

    @NotBlank(message = "Pet id is required")
    private String pet;
    @NotBlank(message = "Name is required")
    private String name;
    @NotNull(message = "Application date is required")
    private LocalDate applicationDate;
    private LocalDate nextDate;


    public VaccinesDTO(Vaccines vaccines){
        this.name = vaccines.getName();
        this.pet = vaccines.getPet().getId();
        this.applicationDate = vaccines.getApplicationDate();
        this.nextDate = vaccines.getNextDate();
    }
}

package com.mypet.application.model.dto;

import com.mypet.application.model.Pet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicationsDTO {

    @NotBlank(message = "Vaccine description is required")
    private String description;
    @NotBlank(message = "Application date is required")
    private LocalDate applicationDate;
    private LocalDate nextDate;
    private Pet pet;

}

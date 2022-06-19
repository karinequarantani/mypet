package com.mypet.application.model.dto;

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
public class PetVaccinesDTO {

    @NotBlank(message = "Pet id is required")
    private String petId;
    @NotBlank(message = "Vaccine id is required")
    private String vaccineId;
    @NotNull(message = "Application date is required")
    private LocalDate applicationDate;
    private LocalDate nextDate;
    private String description;
}

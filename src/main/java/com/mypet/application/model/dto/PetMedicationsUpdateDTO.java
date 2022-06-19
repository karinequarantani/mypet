package com.mypet.application.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PetMedicationsUpdateDTO {
    private LocalDate applicationDate;
    private LocalDate nextDate;
    private String description;
}

package com.mypet.application.model.dto;

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
public class SurgeriesDTO {


    @NotBlank(message = "Surgery name is required")
    private String name;
    private LocalDate date;
    private String vet;
}

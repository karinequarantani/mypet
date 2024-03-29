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
public class WeightDTO {

    @NotNull(message = "Weight is required")
    private Double weight;
    @NotNull(message = "Date is required")
    private LocalDate date;
    @NotBlank(message = "Pet id is required")
    private String petId;
}

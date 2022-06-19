package com.mypet.application.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WeightDTO {

    @NotNull(message = "Weight id is required")
    private Double weight;
    @NotBlank(message = "Pet id is required")
    private String petId;
}

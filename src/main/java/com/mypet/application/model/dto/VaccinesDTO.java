package com.mypet.application.model.dto;

import com.mypet.application.model.Laboratories;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VaccinesDTO {

    @NotBlank(message = "Vaccine name is required")
    private String name;

    private Laboratories laboratory;
}

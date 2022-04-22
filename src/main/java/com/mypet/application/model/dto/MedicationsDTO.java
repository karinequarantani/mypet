package com.mypet.application.model.dto;

import com.mypet.application.model.TypesMedications;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicationsDTO {

    @NotBlank(message = "Vaccine name is required")
    private String name;

    private Set<TypesMedications> typesMedications;
}

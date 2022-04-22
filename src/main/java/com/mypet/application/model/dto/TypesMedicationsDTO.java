package com.mypet.application.model.dto;

import com.mypet.application.model.TypesMedications;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TypesMedicationsDTO {

    @NotBlank(message = "Types medications name is required")
    private String name;

    public TypesMedicationsDTO(TypesMedications typesMedications){
        this.name = typesMedications.getName();
    }
}

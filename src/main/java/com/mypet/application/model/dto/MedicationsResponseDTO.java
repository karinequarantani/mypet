package com.mypet.application.model.dto;

import com.mypet.application.model.Medications;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicationsResponseDTO {

    private String id;
    private String name;

    private Set<TypesMedicationsDTO> typesMedications;

    public MedicationsResponseDTO(Medications medications){
        this.id = medications.getId();
        this.name = medications.getName();
        this.typesMedications = medications.getTypesMedications().stream().map(TypesMedicationsDTO::new).collect(Collectors.toSet());
    }
}

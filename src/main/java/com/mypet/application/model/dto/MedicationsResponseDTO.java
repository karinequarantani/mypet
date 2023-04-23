package com.mypet.application.model.dto;

import com.mypet.application.model.Medications;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicationsResponseDTO {

    private String id;
    private String description;
    private LocalDate applicationDate;
    private LocalDate nextDate;
    private String petId;

    public MedicationsResponseDTO(Medications medications){
        this.id = medications.getId();
        this.description = medications.getDescription();
        this.applicationDate = medications.getApplicationDate();
        this.nextDate = medications.getNextDate();
        this.petId = medications.getPet().getId();
    }
}

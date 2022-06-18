package com.mypet.application.model.dto;

import com.mypet.application.model.PetMedications;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PetMedicationsResponseDTO {

    private LocalDate applicationDate;
    private LocalDate nextDate;
    private String description;

    private PetDTO pet;
    private MedicationsResponseDTO medication;

    public PetMedicationsResponseDTO(PetMedications petMedications){
        this.applicationDate = petMedications.getApplicationDate();
        this.nextDate = petMedications.getNextDate();
        this.description = petMedications.getDescription();
        this.pet = new PetDTO(petMedications.getPet());
        this.medication = new MedicationsResponseDTO(petMedications.getMedication());
    }
}

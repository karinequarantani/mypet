package com.mypet.application.service;

import com.mypet.application.model.PetMedications;
import com.mypet.application.model.dto.PetMedicationsDTO;
import com.mypet.application.model.dto.PetMedicationsResponseDTO;
import com.mypet.application.repository.PetMedicationsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PetMedicationsService {

    private final PetMedicationsRepository petMedicationsRepository;
    private final PetService petService;
    private final MedicationsService medicationsService;

    public PetMedicationsResponseDTO insert(PetMedicationsDTO petMedicationsDTO){
        var pet = petService.findById(petMedicationsDTO.getPetId());
        var medication = medicationsService.findById(petMedicationsDTO.getMedicationId());
        var petMedication = PetMedications.builder()
                .applicationDate(petMedicationsDTO.getApplicationDate())
                .nextDate(petMedicationsDTO.getNextDate())
                .description(petMedicationsDTO.getDescription())
                .pet(pet)
                .medication(medication).build();
        return new PetMedicationsResponseDTO(petMedicationsRepository.save(petMedication));
    }
}
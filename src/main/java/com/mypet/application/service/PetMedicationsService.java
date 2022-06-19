package com.mypet.application.service;

import com.mypet.application.model.PetMedications;
import com.mypet.application.model.dto.PetMedicationsDTO;
import com.mypet.application.model.dto.PetMedicationsResponseDTO;
import com.mypet.application.model.dto.PetMedicationsUpdateDTO;
import com.mypet.application.repository.PetMedicationsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    public Page<PetMedicationsResponseDTO> findByPetId(String petId, Pageable pageable){
        var petMedication = petMedicationsRepository.findAllByPetId(petId, pageable);
        var petMedicationResponseDTOList = petMedication.getContent().stream().map(PetMedicationsResponseDTO::new).toList();
        return new PageImpl<>(petMedicationResponseDTOList, pageable, petMedication.getTotalElements());
    }

    public PetMedicationsResponseDTO update(PetMedicationsUpdateDTO petMedicationsDTO, String petMedicationId){
        var petMedications = petMedicationsRepository.findById(petMedicationId).orElseThrow();
        BeanUtils.copyProperties(petMedicationsDTO, petMedications, getNullFields(petMedicationsDTO));
        petMedications.setUpdatedAt(LocalDateTime.now());
        return new PetMedicationsResponseDTO(petMedicationsRepository.save(petMedications));
    }

    public String[] getNullFields(PetMedicationsUpdateDTO petMedicationsDTO){
        List<String> ignoreFields = new ArrayList<>();
        if (petMedicationsDTO.getApplicationDate() == null){
            ignoreFields.add("applicationDate");
        }
        if(petMedicationsDTO.getNextDate() == null){
            ignoreFields.add("nextDate");
        }
        if(petMedicationsDTO.getDescription() == null){
            ignoreFields.add("description");
        }
        return ignoreFields.toArray(String[]::new);
    }

    public void delete(String petMedicationId) {
        petMedicationsRepository.deleteById(petMedicationId);
    }
}
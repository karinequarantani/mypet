package com.mypet.application.service;

import com.mypet.application.model.Medications;
import com.mypet.application.model.dto.MedicationsDTO;
import com.mypet.application.model.dto.MedicationsResponseDTO;
import com.mypet.application.model.dto.MedicationsUpdateDTO;
import com.mypet.application.repository.MedicationsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class MedicationsService {

    private final MedicationsRepository medicationsRepository;
    private final PetService petService;

    public Medications insert(MedicationsDTO medicationsDTO){
        var pet = petService.findById(medicationsDTO.getPetId());
        var medications = Medications.builder()
                .name(medicationsDTO.getName())
                .description(medicationsDTO.getDescription())
                .applicationDate(medicationsDTO.getApplicationDate())
                .nextDate(medicationsDTO.getNextDate())
                .pet(pet).build();
        return medicationsRepository.save(medications);
    }

    public Page<MedicationsResponseDTO> findByPetId(String petId, Pageable pageable){
        var medications = medicationsRepository.findAllByPetId(petId, pageable);
        var medicationsResponseDTOList = medications.getContent().stream().map(MedicationsResponseDTO::new).toList();
        return new PageImpl<>(medicationsResponseDTOList, pageable, medications.getTotalElements());
    }

    public Medications findById(String id){
        var medication = medicationsRepository.findById(id);
        if(medication.isEmpty()){
            throw new EntityNotFoundException("Medication not found");
        }
        return medication.get();
    }

    public MedicationsResponseDTO update(MedicationsUpdateDTO medicationsUpdateDTO, String vaccineId){
        var medications = medicationsRepository.findById(vaccineId).orElseThrow();
        BeanUtils.copyProperties(medicationsUpdateDTO, medications, getNullFields(medicationsUpdateDTO));
        medications.setUpdatedAt(LocalDateTime.now());
        return new MedicationsResponseDTO(medicationsRepository.save(medications));
    }

    public String[] getNullFields(MedicationsUpdateDTO medicationsUpdateDTO){
        List<String> ignoreFields = new ArrayList<>();
        if (medicationsUpdateDTO.getApplicationDate() == null){
            ignoreFields.add("applicationDate");
        }
        if(medicationsUpdateDTO.getNextDate() == null){
            ignoreFields.add("nextDate");
        }
        if(medicationsUpdateDTO.getDescription() == null){
            ignoreFields.add("description");
        }
        return ignoreFields.toArray(String[]::new);
    }

    public void delete(String medicationsId){
        medicationsRepository.deleteById(medicationsId);
    }

}

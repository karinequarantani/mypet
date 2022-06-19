package com.mypet.application.service;

import com.mypet.application.model.PetVaccines;
import com.mypet.application.model.dto.PetVaccinesDTO;
import com.mypet.application.model.dto.PetVaccinesResponseDTO;
import com.mypet.application.model.dto.PetVaccinesUpdateDTO;
import com.mypet.application.repository.PetVaccinesRepository;
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
public class PetVaccinesService {

    private final PetVaccinesRepository petVaccinesRepository;
    private final PetService petService;
    private final VaccinesService vaccinesService;

    public PetVaccinesResponseDTO insert(PetVaccinesDTO petVaccinesDTO){
        var pet = petService.findById(petVaccinesDTO.getPetId());
        var vaccine = vaccinesService.findById(petVaccinesDTO.getVaccineId());
        var petVaccine = PetVaccines.builder()
                .applicationDate(petVaccinesDTO.getApplicationDate())
                .nextDate(petVaccinesDTO.getNextDate())
                .description(petVaccinesDTO.getDescription())
                .pet(pet)
                .vaccine(vaccine).build();
        return new PetVaccinesResponseDTO(petVaccinesRepository.save(petVaccine));
    }

    public Page<PetVaccinesResponseDTO> findByPetId(String petId, Pageable pageable){
        var petVaccine = petVaccinesRepository.findAllByPetId(petId, pageable);
        var petVaccineResponseDTOList = petVaccine.getContent().stream().map(PetVaccinesResponseDTO::new).toList();
        return new PageImpl<>(petVaccineResponseDTOList, pageable, petVaccine.getTotalElements());
    }

    public PetVaccinesResponseDTO update(PetVaccinesUpdateDTO petVaccinesUpdateDTO, String petVaccineId){
        var petVaccines = petVaccinesRepository.findById(petVaccineId).orElseThrow();
        BeanUtils.copyProperties(petVaccinesUpdateDTO, petVaccines, getNullFields(petVaccinesUpdateDTO));
        petVaccines.setUpdatedAt(LocalDateTime.now());
        return new PetVaccinesResponseDTO(petVaccinesRepository.save(petVaccines));
    }

    public String[] getNullFields(PetVaccinesUpdateDTO petVaccinesUpdateDTO){
        List<String> ignoreFields = new ArrayList<>();
        if (petVaccinesUpdateDTO.getApplicationDate() == null){
            ignoreFields.add("applicationDate");
        }
        if(petVaccinesUpdateDTO.getNextDate() == null){
            ignoreFields.add("nextDate");
        }
        if(petVaccinesUpdateDTO.getDescription() == null){
            ignoreFields.add("description");
        }
        return ignoreFields.toArray(String[]::new);
    }

    public void delete(String petVaccineId){
        petVaccinesRepository.deleteById(petVaccineId);
    }
}

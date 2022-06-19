package com.mypet.application.service;

import com.mypet.application.model.PetVaccines;
import com.mypet.application.model.dto.PetVaccinesDTO;
import com.mypet.application.model.dto.PetVaccinesResponseDTO;
import com.mypet.application.repository.PetVaccinesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
}

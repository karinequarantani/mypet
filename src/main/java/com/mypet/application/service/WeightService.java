package com.mypet.application.service;

import com.mypet.application.model.Weight;
import com.mypet.application.model.dto.WeightDTO;
import com.mypet.application.repository.WeightRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class WeightService {

    private final WeightRepository weightRepository;
    private final PetService petService;

    public Weight insert(WeightDTO weightDTO){
        var pet = petService.findById(weightDTO.getPetId());
        var weight = Weight.builder()
                .weight(weightDTO.getWeight())
                .pet(pet).build();
        return weightRepository.save(weight);
    }

    public Page<Weight> findByPetId(String petId, Pageable pageable) {
        return weightRepository.findAllByPetId(petId, pageable);
    }
}

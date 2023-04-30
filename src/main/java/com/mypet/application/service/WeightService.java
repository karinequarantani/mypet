package com.mypet.application.service;

import com.mypet.application.model.Weight;
import com.mypet.application.model.dto.WeightDTO;
import com.mypet.application.model.dto.WeightResponseDTO;
import com.mypet.application.model.dto.WeightUpdateDTO;
import com.mypet.application.repository.WeightRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
                .date(weightDTO.getDate())
                .pet(pet).build();
        return weightRepository.save(weight);
    }

    public Page<Weight> findByPetId(String petId, Pageable pageable) {
        return weightRepository.findAllByPetId(petId, pageable);
    }

    public WeightResponseDTO update(WeightUpdateDTO weightUpdateDTO, String weightId){
        var weight = weightRepository.findById(weightId).orElseThrow();
        BeanUtils.copyProperties(weightUpdateDTO, weight, getNullFields(weightUpdateDTO));
        weight.setUpdatedAt(LocalDateTime.now());
        return new WeightResponseDTO(weightRepository.save(weight));
    }
    public void delete(String weightId){
        weightRepository.deleteById(weightId);
    }

    public String[] getNullFields(WeightUpdateDTO weightUpdateDTO){
        List<String> ignoreFields = new ArrayList<>();
        if (weightUpdateDTO.getWeight() == null){
            ignoreFields.add("weight");
        }
        if(weightUpdateDTO.getDate() == null){
            ignoreFields.add("date");
        }
        return ignoreFields.toArray(String[]::new);
    }
}

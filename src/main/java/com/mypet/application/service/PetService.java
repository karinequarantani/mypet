package com.mypet.application.service;

import com.mypet.application.model.Pet;
import com.mypet.application.model.dto.PetDTO;
import com.mypet.application.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class PetService {

    private final PetRepository petRepository;

    public Pet insert(PetDTO petDTO){
        var pet = Pet.builder()
                .name(petDTO.getName())
                .breed(petDTO.getBreed())
                .gender(petDTO.getGender())
                .birthday(petDTO.getBirthday())
                .specie(petDTO.getSpecie()).build();
        return petRepository.save(pet);
    }
}

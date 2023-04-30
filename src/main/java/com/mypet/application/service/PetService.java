package com.mypet.application.service;

import com.mypet.application.model.Pet;
import com.mypet.application.model.dto.PetDTO;
import com.mypet.application.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class PetService {

    private final PetRepository petRepository;
    private final TutorService tutorService;

    public Pet insert(PetDTO petDTO){
        var tutor = tutorService.findById(petDTO.getTutorId());
        var pet = Pet.builder()
                .name(petDTO.getName())
                .breed(petDTO.getBreed())
                .gender(petDTO.getGender())
                .birthday(petDTO.getBirthday())
                .specie(petDTO.getSpecie())
                .rationBrand(petDTO.getRationBrand())
                .feedName(petDTO.getFeedName())
                .amount(petDTO.getAmount())
                .firstFeeding(petDTO.getFirstFeeding())
                .secondFeeding(petDTO.getSecondFeeding())
                .firstWalk(petDTO.getFirstWalk())
                .secondWalk(petDTO.getSecondWalk())
                .tutor(tutor).build();
        return petRepository.save(pet);
    }

    public Page<Pet> findAllByTutorId(String tutorId, Pageable pageable){
        return petRepository.findAllByTutorId(tutorId, pageable);
    }

    public Pet findById(String id){
        var pet = petRepository.findById(id);
        if(pet.isEmpty()){
            throw new EntityNotFoundException("Pet not found");
        }
        return pet.get();
    }

    public Pet update(PetDTO petDTO, String petId){
        var pet = petRepository.findById(petId).orElseThrow();
        BeanUtils.copyProperties(petDTO, pet, getNullFields(petDTO));
        pet.setUpdatedAt(LocalDateTime.now());
        return petRepository.save(pet);
    }

    public void delete(String petId){
        petRepository.deleteById(petId);
    }

    public String[] getNullFields(PetDTO petDTO){
        List<String> ignoreFields = new ArrayList<>();
        if (petDTO.getName() == null){
            ignoreFields.add("name");
        }
        if(petDTO.getBreed() == null){
            ignoreFields.add("breed");
        }
        if(petDTO.getGender() == null){
            ignoreFields.add("gender");
        }
        if(petDTO.getBirthday() == null){
            ignoreFields.add("birthday");
        }
        if(petDTO.getSpecie() == null){
            ignoreFields.add("specie");
        }
        if(petDTO.getRationBrand() == null){
            ignoreFields.add("rationBrand");
        }
        if(petDTO.getFeedName() == null){
            ignoreFields.add("feedName");
        }
        if(petDTO.getAmount() == null){
            ignoreFields.add("amount");
        }
        if(petDTO.getFirstFeeding() == null){
            ignoreFields.add("firstFeeding");
        }
        if(petDTO.getSecondFeeding() == null){
            ignoreFields.add("secondFeeding");
        }
        if(petDTO.getFirstWalk() == null){
            ignoreFields.add("firstWalk");
        }
        if(petDTO.getSecondWalk() == null){
            ignoreFields.add("secondWalk");
        }
        return ignoreFields.toArray(String[]::new);
    }
}

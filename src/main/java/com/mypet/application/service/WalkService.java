package com.mypet.application.service;

import com.mypet.application.model.WalkControl;
import com.mypet.application.model.dto.WalkDTO;
import com.mypet.application.model.dto.WalkResponseDTO;
import com.mypet.application.model.dto.WalkUpdateDTO;
import com.mypet.application.repository.WalkRepository;
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
public class WalkService {

    private final WalkRepository walkRepository;
    private final PetService petService;

    public WalkControl insert(WalkDTO walkDTO){
        var pet = petService.findById(walkDTO.getPetId());
        var walk = WalkControl.builder()
                .date(walkDTO.getDate())
                .distance(walkDTO.getDistance())
                .time(walkDTO.getTime())
                .pet(pet).build();
        return walkRepository.save(walk);
    }

    public Page<WalkControl> findByPetId(String petId, Pageable pageable) {
        return walkRepository.findAllByPetIdOrderByDateDesc(petId, pageable);
    }

    public WalkResponseDTO update(WalkUpdateDTO walkUpdateDTO, String walkId){
        var walk = walkRepository.findById(walkId).orElseThrow();
        BeanUtils.copyProperties(walkUpdateDTO, walk, getNullFields(walkUpdateDTO));
        walk.setUpdatedAt(LocalDateTime.now());
        return new WalkResponseDTO(walkRepository.save(walk));
    }
    public void delete(String walkId){
        walkRepository.deleteById(walkId);
    }

    public String[] getNullFields(WalkUpdateDTO walkUpdateDTO){
        List<String> ignoreFields = new ArrayList<>();
        if (walkUpdateDTO.getDate() == null){
            ignoreFields.add("date");
        }
        if(walkUpdateDTO.getDistance() == null){
            ignoreFields.add("distance");
        }
        if(walkUpdateDTO.getTime() == null){
            ignoreFields.add("time");
        }
        return ignoreFields.toArray(String[]::new);
    }
}

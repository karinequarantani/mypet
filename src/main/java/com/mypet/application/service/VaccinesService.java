package com.mypet.application.service;

import com.mypet.application.model.Vaccines;
import com.mypet.application.model.dto.VaccinesDTO;
import com.mypet.application.model.dto.VaccinesResponseDTO;
import com.mypet.application.model.dto.VaccinesUpdateDTO;
import com.mypet.application.repository.VaccinesRepository;
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
public class VaccinesService {

    protected final VaccinesRepository vaccinesRepository;
    private final PetService petService;

    public Vaccines insert(VaccinesDTO vaccinesDTO){
        var pet = petService.findById(vaccinesDTO.getPet());
        var vaccines = Vaccines.builder()
                        .name(vaccinesDTO.getName())
                        .applicationDate(vaccinesDTO.getApplicationDate())
                        .nextDate(vaccinesDTO.getNextDate())
                        .pet(pet).build();
        return vaccinesRepository.save(vaccines);
    }

    public List<Vaccines> findAll(){
        return vaccinesRepository.findAll();
    }

    public Vaccines findById(String id){
        var vaccine = vaccinesRepository.findById(id);
        if(vaccine.isEmpty()){
            throw new EntityNotFoundException("Vaccine not found");
        }
        return vaccine.get();
    }

    public Page<VaccinesResponseDTO> findByPetId(String petId, Pageable pageable){
        var vaccines = vaccinesRepository.findAllByPetId(petId, pageable);
        var vaccineResponseDTOList = vaccines.getContent().stream().map(VaccinesResponseDTO::new).toList();
        return new PageImpl<>(vaccineResponseDTOList, pageable, vaccines.getTotalElements());
    }

    public VaccinesResponseDTO update(VaccinesUpdateDTO vaccinesUpdateDTO, String vaccineId){
        var vaccines = vaccinesRepository.findById(vaccineId).orElseThrow();
        BeanUtils.copyProperties(vaccinesUpdateDTO, vaccines, getNullFields(vaccinesUpdateDTO));
        vaccines.setUpdatedAt(LocalDateTime.now());
        return new VaccinesResponseDTO(vaccinesRepository.save(vaccines));
    }

    public String[] getNullFields(VaccinesUpdateDTO vaccinesUpdateDTO){
        List<String> ignoreFields = new ArrayList<>();
        if (vaccinesUpdateDTO.getApplicationDate() == null){
            ignoreFields.add("applicationDate");
        }
        if(vaccinesUpdateDTO.getNextDate() == null){
            ignoreFields.add("nextDate");
        }
        if(vaccinesUpdateDTO.getName() == null){
            ignoreFields.add("name");
        }
        return ignoreFields.toArray(String[]::new);
    }

    public void delete(String petVaccineId){
        vaccinesRepository.deleteById(petVaccineId);
    }
}

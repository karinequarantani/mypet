package com.mypet.application.service;

import com.mypet.application.model.Vaccines;
import com.mypet.application.model.dto.VaccinesDTO;
import com.mypet.application.repository.VaccinesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class VaccinesService {

    protected final VaccinesRepository vaccinesRepository;

    public Vaccines insert(VaccinesDTO vaccinesDTO){
        var vaccines = Vaccines.builder()
                        .name(vaccinesDTO.getName())
                        .laboratory(vaccinesDTO.getLaboratory()).build();
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
}

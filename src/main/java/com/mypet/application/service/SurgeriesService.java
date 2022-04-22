package com.mypet.application.service;

import com.mypet.application.model.Surgeries;
import com.mypet.application.model.dto.SurgeriesDTO;
import com.mypet.application.model.dto.SurgeriesUpdateDTO;
import com.mypet.application.repository.SurgeriesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class SurgeriesService {

    private final SurgeriesRepository surgeriesRepository;

    public Surgeries insert(SurgeriesDTO surgeriesDTO){
        var surgeries = Surgeries.builder()
                .name(surgeriesDTO.getName())
                .date(surgeriesDTO.getDate())
                .vet(surgeriesDTO.getVet()).build();
        return surgeriesRepository.save(surgeries);
    }

    public List<Surgeries> findAll(){
        return surgeriesRepository.findAll();
    }

    public Surgeries update(SurgeriesUpdateDTO surgeriesUpdateDTO, String surgeryId){
        var surgery = surgeriesRepository.findById(surgeryId).orElseThrow();
        BeanUtils.copyProperties(surgeriesUpdateDTO, surgery, getNullFields(surgeriesUpdateDTO));
        surgery.setUpdatedAt(LocalDateTime.now());
        return surgeriesRepository.save(surgery);
    }

    public void delete(String surgeryId){
        surgeriesRepository.deleteById(surgeryId);
    }

    public String[] getNullFields(SurgeriesUpdateDTO surgeriesUpdateDTO){
        List<String> ignoreFields = new ArrayList<>();
        if (surgeriesUpdateDTO.getName() == null){
            ignoreFields.add("name");
        }
        if(surgeriesUpdateDTO.getDate() == null){
            ignoreFields.add("date");
        }
        if(surgeriesUpdateDTO.getVet() == null){
            ignoreFields.add("vet");
        }
        return ignoreFields.toArray(String[]::new);
    }
}

package com.mypet.application.service;

import com.mypet.application.model.Surgeries;
import com.mypet.application.model.dto.SurgeriesDTO;
import com.mypet.application.repository.SurgeriesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
}

package com.mypet.application.service;

import com.mypet.application.model.Laboratories;
import com.mypet.application.model.dto.LaboratoriesDTO;
import com.mypet.application.repository.LaboratoriesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class LaboratoriesService {

    private final LaboratoriesRepository laboratoriesRepository;

    public Laboratories insert(LaboratoriesDTO laboratoriesDTO){
        var laboratories = Laboratories.builder()
                .name(laboratoriesDTO.getName()).build();
        return laboratoriesRepository.save(laboratories);
    }
}

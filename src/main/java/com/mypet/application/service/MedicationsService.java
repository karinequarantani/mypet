package com.mypet.application.service;

import com.mypet.application.model.Medications;
import com.mypet.application.model.dto.MedicationsDTO;
import com.mypet.application.repository.MedicationsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class MedicationsService {

    private final MedicationsRepository medicationsRepository;

    public Medications insert(MedicationsDTO medicationsDTO){
        var medications = Medications.builder()
                .name(medicationsDTO.getName()).build();
        return medicationsRepository.save(medications);
    }
}

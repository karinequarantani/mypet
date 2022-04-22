package com.mypet.application.service;

import com.mypet.application.model.Medications;
import com.mypet.application.model.dto.MedicationsDTO;
import com.mypet.application.model.dto.MedicationsResponseDTO;
import com.mypet.application.repository.MedicationsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class MedicationsService {

    private final MedicationsRepository medicationsRepository;

    public Medications insert(MedicationsDTO medicationsDTO){
        var medications = Medications.builder()
                .name(medicationsDTO.getName())
                .typesMedications(medicationsDTO.getTypesMedications()).build();
        return medicationsRepository.save(medications);
    }

    public Page<MedicationsResponseDTO> findAll(Pageable pageable){
        var medications =  medicationsRepository.findAll(pageable);
        var medicationsResponseDTOList = medications.getContent().stream().map(MedicationsResponseDTO::new).toList();

        return new PageImpl<>(medicationsResponseDTOList, pageable, medications.getTotalElements());
    }
}

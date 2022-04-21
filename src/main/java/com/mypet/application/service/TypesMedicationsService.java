package com.mypet.application.service;

import com.mypet.application.model.TypesMedications;
import com.mypet.application.model.dto.TypesMedicationsDTO;
import com.mypet.application.repository.TypesMedicationsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class TypesMedicationsService {

    private final TypesMedicationsRepository typesMedicationsRepository;
    public TypesMedications insert(TypesMedicationsDTO typesMedicationsDTO) {
        var typesMedications = TypesMedications.builder()
                .name(typesMedicationsDTO.getName()).build();
        return typesMedicationsRepository.save(typesMedications);
    }

    public List<TypesMedications> findAll() {
        return typesMedicationsRepository.findAll();
    }
}

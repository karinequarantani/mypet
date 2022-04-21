package com.mypet.application.service;

import com.mypet.application.model.TypesMedications;
import com.mypet.application.model.dto.TypesMedicationsDTO;
import com.mypet.application.repository.TypesMedicationsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class TypesMedicationsService {

    private final TypesMedicationsRepository typesMedicationsRepository;
    public TypesMedications insert(TypesMedicationsDTO typesMedicationsDTO) {
        var typesMedications = TypesMedications.builder()
                .id(UUID.randomUUID().toString())
                .name(typesMedicationsDTO.getName())
                .createdAt(LocalDateTime.now()).build();

        return typesMedicationsRepository.save(typesMedications);
    }

    public List<TypesMedications> findAll() {
        return typesMedicationsRepository.findAll();
    }
}

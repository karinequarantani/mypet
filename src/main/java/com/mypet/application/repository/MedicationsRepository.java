package com.mypet.application.repository;

import com.mypet.application.model.Medications;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationsRepository extends JpaRepository<Medications, String> {

    Page<Medications> findAllByPetId(String petId, Pageable pageable);
}

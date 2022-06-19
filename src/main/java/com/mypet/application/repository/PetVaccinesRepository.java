package com.mypet.application.repository;

import com.mypet.application.model.PetVaccines;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetVaccinesRepository extends JpaRepository<PetVaccines, String> {

    Page<PetVaccines> findAllByPetId(String petId, Pageable pageable);
}

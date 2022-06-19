package com.mypet.application.repository;

import com.mypet.application.model.Surgeries;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurgeriesRepository extends JpaRepository<Surgeries, String> {

    Page<Surgeries> findAllByPetId(String petId, Pageable pageable);
}

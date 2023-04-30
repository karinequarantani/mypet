package com.mypet.application.repository;

import com.mypet.application.model.Weight;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeightRepository extends JpaRepository<Weight, String> {
    Page<Weight> findAllByPetIdOrderByDateDesc(String petId, Pageable pageable);

}

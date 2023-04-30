package com.mypet.application.repository;

import com.mypet.application.model.WalkControl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalkRepository extends JpaRepository<WalkControl, String> {

    Page<WalkControl> findAllByPetIdOrderByDateDesc(String petId, Pageable pageable);
}

package com.mypet.application.repository;

import com.mypet.application.model.Pet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, String> {

    Page<Pet> findAllByTutorId(String tutorId, Pageable pageable);
}

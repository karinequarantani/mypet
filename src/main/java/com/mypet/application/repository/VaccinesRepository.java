package com.mypet.application.repository;

import com.mypet.application.model.Vaccines;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccinesRepository extends JpaRepository<Vaccines, String> {

    Page<Vaccines> findAllByPetId(String petId, Pageable pageable);
}

package com.mypet.application.repository;

import com.mypet.application.model.PetVaccines;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetVaccinesRepository extends JpaRepository<PetVaccines, String> {
}

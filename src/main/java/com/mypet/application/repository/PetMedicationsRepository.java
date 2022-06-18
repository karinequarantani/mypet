package com.mypet.application.repository;

import com.mypet.application.model.PetMedications;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetMedicationsRepository extends JpaRepository<PetMedications, String> {
}

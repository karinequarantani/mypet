package com.mypet.application.repository;

import com.mypet.application.model.Medications;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationsRepository extends JpaRepository<Medications, String> {
}

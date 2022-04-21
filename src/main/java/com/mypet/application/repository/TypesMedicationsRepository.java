package com.mypet.application.repository;

import com.mypet.application.model.TypesMedications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypesMedicationsRepository  extends JpaRepository<TypesMedications, String> {
}

package com.mypet.application.repository;

import com.mypet.application.model.Vaccines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccinesRepository extends JpaRepository<Vaccines, String> {
}

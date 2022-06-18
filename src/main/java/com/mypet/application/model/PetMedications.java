package com.mypet.application.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class PetMedications extends BaseEntity{

    private LocalDate applicationDate;
    private LocalDate nextDate;
    private String description;
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "id_pet")
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "id_medication")
    private Medications medication;
}

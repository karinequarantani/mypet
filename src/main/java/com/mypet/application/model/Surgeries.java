package com.mypet.application.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Surgeries extends BaseEntity {

    @Column(nullable = false)
    private String name;

    private LocalDate date;
    private String vet;
    private LocalDateTime updatedAt;

    @ManyToOne
    private Pet pet;
}

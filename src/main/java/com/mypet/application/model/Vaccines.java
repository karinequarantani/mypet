package com.mypet.application.model;

import lombok.*;

import javax.persistence.CascadeType;
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
public class Vaccines extends BaseEntity {

    @Column(nullable = false)
    private String name;
    private LocalDate applicationDate;
    private LocalDate nextDate;
    private LocalDateTime updatedAt;

    @ManyToOne(cascade= CascadeType.REMOVE)
    private Pet pet;
}

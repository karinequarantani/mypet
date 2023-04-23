package com.mypet.application.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Medications extends BaseEntity {

    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private LocalDate applicationDate;
    private LocalDate nextDate;
    private LocalDateTime updatedAt;

    @ManyToOne(cascade= CascadeType.REMOVE)
    private Pet pet;

}

package com.mypet.application.model;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Pet pet;

}

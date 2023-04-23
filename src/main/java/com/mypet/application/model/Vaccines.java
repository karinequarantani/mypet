package com.mypet.application.model;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
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
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Pet pet;
}

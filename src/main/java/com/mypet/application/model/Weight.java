package com.mypet.application.model;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
public class Weight extends BaseEntity{

    private Double weight;
    private LocalDate date;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Pet pet;
    private LocalDateTime updatedAt;
}

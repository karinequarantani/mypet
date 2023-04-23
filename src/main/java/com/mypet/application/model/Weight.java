package com.mypet.application.model;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Weight extends BaseEntity{

    private Double weight;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Pet pet;
}

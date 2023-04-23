package com.mypet.application.model;

import lombok.*;

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

    @ManyToOne(cascade= CascadeType.REMOVE)
    private Pet pet;
}

package com.mypet.application.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Vaccines extends BaseEntity {


    @Column(nullable = false)
    private String name;

    @ManyToOne
    private Laboratories laboratory;
}

package com.mypet.application.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Medications extends BaseEntity {

    @Column(nullable = false)
    private String name;
}

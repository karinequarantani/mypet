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
public class Laboratories extends BaseEntity{

    @Column(nullable = false, unique = true)
    private String name;
}

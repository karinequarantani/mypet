package com.mypet.application.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Medications extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(
            name = "medications_types_medications",
            joinColumns = @JoinColumn(name = "medications_id"),
            inverseJoinColumns = @JoinColumn(name = "type_medications_id"))
    private Set<TypesMedications> typesMedications;
}

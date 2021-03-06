package com.mypet.application.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Column;
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
public class Pet extends BaseEntity{

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String breed;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private LocalDate birthday;

    @Column(nullable = false)
    private String specie;

    private LocalDateTime updatedAt;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    private Tutor tutor;
}

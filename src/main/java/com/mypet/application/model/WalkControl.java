package com.mypet.application.model;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class WalkControl extends BaseEntity{

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(nullable = false)
    private Integer distance;

    private Integer time;
    private LocalDateTime updatedAt;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Pet pet;
}

package com.mypet.application.model.dto;

import com.mypet.application.model.WalkControl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WalkResponseDTO {

    private String id;
    private LocalDateTime date;
    private Integer distance;
    private Integer time;
    private PetDTO pet;

    public WalkResponseDTO(WalkControl walk){
        this.id = walk.getId();
        this.date = walk.getDate();
        this.distance = walk.getDistance();
        this.time = walk.getTime();
        this.pet = new PetDTO(walk.getPet());
    }
}

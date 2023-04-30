package com.mypet.application.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WalkDTO {

    @NotNull(message = "Date is required")
    private LocalDateTime date;
    @NotNull(message = "Distance is required")
    private Integer distance;
    @NotNull(message = "Time is required")
    private Integer time;
    @NotBlank(message = "Pet id is required")
    private String petId;
}

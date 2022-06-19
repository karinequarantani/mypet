package com.mypet.application.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TutorDTO {

    @NotBlank(message = "Tutor name is required")
    private String name;

    @NotNull(message = "Tutor birthday is required")
    private LocalDate birthday;

    @NotBlank(message = "Tutor gender is required")
    private String gender;

    @NotBlank(message = "Tutor phone is required")
    private String phone;

    @NotBlank(message = "Tutor email is required")
    private String email;


}

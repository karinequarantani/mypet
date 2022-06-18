package com.mypet.application.model.dto;

import com.mypet.application.model.Pet;
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
public class PetDTO {

    @NotBlank(message = "Pet name is required")
    private String name;

    @NotBlank(message = "Pet breed is required")
    private String breed;

    @NotBlank(message = "Pet gender is required")
    private String gender;

    @NotNull(message = "Pet birthday is required")
    private LocalDate birthday;

    @NotBlank(message = "Pet specie is required")
    private String specie;

    public PetDTO(Pet pet){
        this.name = pet.getName();
        this.breed = pet.getBreed();
        this.gender = pet.getGender();
        this.birthday = pet.getBirthday();
        this.specie = pet.getSpecie();
    }
}

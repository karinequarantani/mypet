package com.mypet.application.model.dto;

import com.mypet.application.model.Pet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Time;
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

    private String rationBrand;
    private String feedName;
    private String amount;
    private Time firstFeeding;
    private Time secondFeeding;
    private Time firstWalk;
    private Time secondWalk;

    @NotBlank(message = "Tutor id is required")
    private String tutorId;

    public PetDTO(Pet pet){
        this.name = pet.getName();
        this.breed = pet.getBreed();
        this.gender = pet.getGender();
        this.birthday = pet.getBirthday();
        this.specie = pet.getSpecie();
        this.rationBrand = pet.getRationBrand();
        this.feedName = pet.getFeedName();
        this.amount = pet.getAmount();
        this.firstFeeding = pet.getFirstFeeding();
        this.secondFeeding = pet.getSecondFeeding();
        this.firstWalk = pet.getFirstWalk();
        this.secondWalk = pet.getSecondWalk();
        this.tutorId = pet.getTutor().getId();
    }
}

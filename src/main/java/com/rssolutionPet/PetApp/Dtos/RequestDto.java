package com.rssolutionPet.PetApp.Dtos;

import com.rssolutionPet.PetApp.Enum.PetStatus;
import com.rssolutionPet.PetApp.Models.Category;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class RequestDto {
    private Category category;
    private String name;
    private PetStatus status;
}

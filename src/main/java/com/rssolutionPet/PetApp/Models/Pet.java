package com.rssolutionPet.PetApp.Models;

import com.rssolutionPet.PetApp.Enum.PetStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;
    private PetStatus status;
}

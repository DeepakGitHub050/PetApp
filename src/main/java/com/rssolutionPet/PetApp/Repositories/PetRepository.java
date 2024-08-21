package com.rssolutionPet.PetApp.Repositories;

import com.rssolutionPet.PetApp.Enum.PetStatus;
import com.rssolutionPet.PetApp.Models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Integer> {
    List<Pet> findPetsByStatus(PetStatus status);
}

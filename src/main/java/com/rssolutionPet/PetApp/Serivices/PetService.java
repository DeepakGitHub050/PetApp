package com.rssolutionPet.PetApp.Serivices;

import com.rssolutionPet.PetApp.Models.Pet;
import com.rssolutionPet.PetApp.Enum.PetStatus;
import com.rssolutionPet.PetApp.Repositories.PetRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PetService {
    private final PetRepository petRepository;
    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public void savePetDetails(Pet pet) {
        petRepository.save(pet);
    }
    public List<Pet> getPetsByStatus(PetStatus status) {
        return petRepository.findPetsByStatus(status);
    }
}

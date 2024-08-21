package com.rssolutionPet.PetApp.Controller;

import com.rssolutionPet.PetApp.Dtos.RequestDto;
import com.rssolutionPet.PetApp.Enum.PetStatus;
import com.rssolutionPet.PetApp.Models.Pet;
import com.rssolutionPet.PetApp.Serivices.PetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class PetController {
    private final PetService petService;
    public PetController(PetService petService) {
        this.petService = petService;
    }
    Set<PetStatus> StatusSet = Arrays.stream(PetStatus.values()).collect(Collectors.toSet());

    @GetMapping("/{status}")
    public ResponseEntity<List<Pet>> getPet(@PathVariable PetStatus status) {
        if(StatusSet.contains(status)){
            return new ResponseEntity<>(petService.getPetsByStatus(status), HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping
    public ResponseEntity<Pet> postPet(@RequestBody RequestDto request) {
        Pet pet = new Pet();
        pet.setName(request.getName());
        pet.setCategory(request.getCategory());
        if(StatusSet.contains(request.getStatus()))
            pet.setStatus(request.getStatus());
        else
            return new ResponseEntity<>(pet, HttpStatus.BAD_REQUEST);
        petService.savePetDetails(pet);
        return new ResponseEntity<>(pet, HttpStatus.CREATED);
    }
}

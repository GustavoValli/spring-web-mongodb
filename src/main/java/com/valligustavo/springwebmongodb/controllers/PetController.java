package com.valligustavo.springwebmongodb.controllers;

import com.valligustavo.springwebmongodb.domain.pet.Pet;
import com.valligustavo.springwebmongodb.dto.pet.PetDTO;
import com.valligustavo.springwebmongodb.dto.pet.PetIdDTO;
import com.valligustavo.springwebmongodb.services.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/pets")
@RequiredArgsConstructor
public class PetController {
    private final PetService petService;

    @GetMapping
    public ResponseEntity<List<Pet>> findAll() {
        List<Pet> petList = this.petService.findAll();
        return ResponseEntity.ok().body(petList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetDTO> findById(@PathVariable String id) {
        Pet pet = this.petService.findById(id);
        PetDTO petDTO = new PetDTO(pet.getName(), pet.getSize(), pet.getAge(), pet.getAdoptionCenter());
        return ResponseEntity.ok().body(petDTO);
    }

    @PostMapping
    public ResponseEntity<PetIdDTO> createPet(@RequestBody PetDTO request, UriComponentsBuilder uriComponentsBuilder) {
        PetIdDTO petIdDTO = this.petService.createPet(request);

        var uri = uriComponentsBuilder.path("/pets/{id}").buildAndExpand(petIdDTO.id()).toUri();

        return ResponseEntity.created(uri).body(petIdDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePet(@PathVariable String id) {
        this.petService.deletePet(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/search")
    public ResponseEntity<Pet> search(
            @RequestParam(value = "name", defaultValue = "") String name,
            @RequestParam(value = "size", defaultValue = "") String size,
            @RequestParam(value = "age", defaultValue = "") Integer age
    ) {
        Pet pet = this.petService.search(name, size, age);
        return ResponseEntity.ok().body(pet);
    }

    @GetMapping("/findByName")
    public ResponseEntity<Pet> findByName(
            @RequestParam(value = "name", defaultValue = "") String name
    ) {
        Pet pet = this.petService.findByName(name);
        return ResponseEntity.ok().body(pet);
    }
}

package com.valligustavo.springwebmongodb.controllers;

import com.valligustavo.springwebmongodb.domain.pet.Pet;
import com.valligustavo.springwebmongodb.services.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

package com.valligustavo.springwebmongodb.services;

import com.valligustavo.springwebmongodb.domain.pet.Pet;
import com.valligustavo.springwebmongodb.repositories.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetService {
    private final PetRepository petRepository;

    public List<Pet> findAll() {
        return this.petRepository.findAll();
    }
}

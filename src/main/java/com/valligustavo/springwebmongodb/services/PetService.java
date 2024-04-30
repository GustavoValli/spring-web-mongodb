package com.valligustavo.springwebmongodb.services;

import com.valligustavo.springwebmongodb.domain.adoptioncenter.AdoptionCenter;
import com.valligustavo.springwebmongodb.domain.pet.Pet;
import com.valligustavo.springwebmongodb.domain.pet.exceptions.PetNotFoundException;
import com.valligustavo.springwebmongodb.dto.pet.PetDTO;
import com.valligustavo.springwebmongodb.dto.pet.PetIdDTO;
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

    public Pet findById(String id) {
        return this.petRepository.findById(id).orElseThrow(
                () -> new PetNotFoundException("Can't find the pet with ID:" + id)
        );
    }

    public PetIdDTO createPet(PetDTO request) {
        Pet newPet = new Pet();
        newPet.setName(request.name());
        newPet.setSize(request.size());
        newPet.setAge(request.age());

        this.petRepository.save(newPet);

        return new PetIdDTO(newPet.getId());
    }

    public Pet registerPet(PetIdDTO petId, AdoptionCenter adoptionCenter) {
        Pet pet = this.findById(petId.id());
        pet.setAdoptionCenter(adoptionCenter);
        this.petRepository.save(pet);
        return pet;
    }

    public void deletePet(String id) {
        this.petRepository.deleteById(id);
    }
}

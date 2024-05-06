package com.valligustavo.springwebmongodb.services;

import com.valligustavo.springwebmongodb.domain.adoptioncenter.AdoptionCenter;
import com.valligustavo.springwebmongodb.domain.adoptioncenter.exceptions.AdoptionCenterNotFoundException;
import com.valligustavo.springwebmongodb.domain.pet.Pet;
import com.valligustavo.springwebmongodb.dto.adoptioncenter.AdoptionCenterIdDTO;
import com.valligustavo.springwebmongodb.dto.adoptioncenter.AdoptionCenterDTO;
import com.valligustavo.springwebmongodb.dto.pet.PetIdDTO;
import com.valligustavo.springwebmongodb.repositories.AdoptionCenterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdoptionCenterService {
    private final AdoptionCenterRepository adoptionCenterRepository;
    private final PetService petService;

    public List<AdoptionCenter> findAll() {
        return this.adoptionCenterRepository.findAll();
    }

    public AdoptionCenter findById(String id) {
        return this.adoptionCenterRepository.findById(id).orElseThrow(
                () -> new AdoptionCenterNotFoundException("Can't find the adoption center with ID: " + id)
        );
    }

    public AdoptionCenterIdDTO createAdoptionCenter(AdoptionCenterDTO request) {
        AdoptionCenter newAdoptionCenter = new AdoptionCenter();
        newAdoptionCenter.setName(request.name());
        newAdoptionCenter.setLocation(request.location());

        this.adoptionCenterRepository.save(newAdoptionCenter);

        return new AdoptionCenterIdDTO(newAdoptionCenter.getId());
    }

    public PetIdDTO RegisterPet(String centerId, PetIdDTO petId) {
        AdoptionCenter adoptionCenter = this.findById(centerId);
        Pet pet = petService.registerPet(petId, adoptionCenter);

        adoptionCenter.getPets().add(pet);
        this.adoptionCenterRepository.save(adoptionCenter);

        return new PetIdDTO(pet.getId());
    }

    public void deleteAdoptionCenter(String id) {
        this.adoptionCenterRepository.deleteById(id);
    }

    public AdoptionCenter search(String name, String location) {
        return this.adoptionCenterRepository.search(name, location);
    }

    public AdoptionCenter findByName(String name) {
        return this.adoptionCenterRepository.findByName(name);
    }
}

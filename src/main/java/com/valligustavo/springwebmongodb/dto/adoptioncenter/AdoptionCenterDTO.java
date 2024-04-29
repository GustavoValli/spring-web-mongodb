package com.valligustavo.springwebmongodb.dto.adoptioncenter;

import com.valligustavo.springwebmongodb.domain.pet.Pet;

import java.util.List;

public record AdoptionCenterDTO(
        String name,
        String location,
        List<Pet> pets
) {
}

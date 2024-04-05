package com.valligustavo.springwebmongodb.dto.pet;

import com.valligustavo.springwebmongodb.domain.adoptioncenter.AdoptionCenter;

public record PetDTO (
        String name,
        String size,
        Integer age,
        AdoptionCenter adoptionCenter
) {
}

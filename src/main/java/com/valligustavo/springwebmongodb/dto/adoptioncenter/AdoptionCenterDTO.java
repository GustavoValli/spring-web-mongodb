package com.valligustavo.springwebmongodb.dto.adoptioncenter;

public record AdoptionCenterDTO(
        String name,
        String location,
        Integer numberOfPets
) {
}

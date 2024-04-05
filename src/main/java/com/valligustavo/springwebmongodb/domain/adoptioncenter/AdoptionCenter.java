package com.valligustavo.springwebmongodb.domain.adoptioncenter;

import com.valligustavo.springwebmongodb.domain.pet.Pet;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "adoption-center")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdoptionCenter {

    @Id
    private String id;
    private String name;
    private String location;
    private Integer numberOfPets;

    @DBRef(lazy = true)
    private List<Pet> pets = new ArrayList<>();
}

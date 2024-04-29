package com.valligustavo.springwebmongodb.domain.pet;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.valligustavo.springwebmongodb.domain.adoptioncenter.AdoptionCenter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pets")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pet {
    @Id
    private String id;
    private String name;
    private String size;
    private Integer age;

    @JsonIgnore
    private AdoptionCenter adoptionCenter;
}

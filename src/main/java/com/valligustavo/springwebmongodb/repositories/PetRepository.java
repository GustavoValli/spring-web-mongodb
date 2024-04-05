package com.valligustavo.springwebmongodb.repositories;

import com.valligustavo.springwebmongodb.domain.pet.Pet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends MongoRepository<Pet, String> {
}

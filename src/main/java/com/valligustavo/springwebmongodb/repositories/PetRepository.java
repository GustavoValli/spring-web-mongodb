package com.valligustavo.springwebmongodb.repositories;

import com.valligustavo.springwebmongodb.domain.pet.Pet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends MongoRepository<Pet, String> {
    @Query("{ 'name': { $regex: ?0, $options: 'i' }, 'size': { $regex: ?1, $options: 'i' }, 'age': ?2 }")
    Pet search(String name, String size, Integer age);

    @Query("{ 'name': { $regex: ?0, $options: 'i' } }")
    Pet findByName(String name);
}

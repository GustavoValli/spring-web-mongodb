package com.valligustavo.springwebmongodb.repositories;

import com.valligustavo.springwebmongodb.domain.adoptioncenter.AdoptionCenter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdoptionCenterRepository extends MongoRepository<AdoptionCenter, String> {
    @Query("{ 'name': { $regex: ?0, $options: 'i' }, 'location': { $regex: ?1, $options: 'i' } }")
    AdoptionCenter search(String name, String location);

    @Query("{ 'name': { $regex: ?0, $options: 'i' } }")
    AdoptionCenter findByName(String name);
}

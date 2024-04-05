package com.valligustavo.springwebmongodb.repositories;

import com.valligustavo.springwebmongodb.domain.adoptioncenter.AdoptionCenter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdoptionCenterRepository extends MongoRepository<AdoptionCenter, String> {
}

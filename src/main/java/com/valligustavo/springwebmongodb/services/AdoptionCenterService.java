package com.valligustavo.springwebmongodb.services;

import com.valligustavo.springwebmongodb.domain.adoptioncenter.AdoptionCenter;
import com.valligustavo.springwebmongodb.repositories.AdoptionCenterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdoptionCenterService {
    private final AdoptionCenterRepository adoptionCenterRepository;

    public List<AdoptionCenter> findAll() {
        return this.adoptionCenterRepository.findAll();
    }
}

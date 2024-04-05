package com.valligustavo.springwebmongodb.controllers;

import com.valligustavo.springwebmongodb.domain.adoptioncenter.AdoptionCenter;
import com.valligustavo.springwebmongodb.dto.adoptioncenter.AdoptionCenterIdDTO;
import com.valligustavo.springwebmongodb.dto.adoptioncenter.AdoptionCenterDTO;
import com.valligustavo.springwebmongodb.services.AdoptionCenterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/centers")
@RequiredArgsConstructor
public class AdoptionCenterController {
    private final AdoptionCenterService adoptionCenterService;

    @GetMapping
    public ResponseEntity<List<AdoptionCenter>> findAll() {
        List<AdoptionCenter> adoptionCenterList = this.adoptionCenterService.findAll();
        return ResponseEntity.ok().body(adoptionCenterList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdoptionCenterDTO> findById(@PathVariable String id) {
        AdoptionCenter adoptionCenter = this.adoptionCenterService.findById(id);
        AdoptionCenterDTO adoptionCenterDTO = new AdoptionCenterDTO(adoptionCenter.getName(), adoptionCenter.getLocation(), adoptionCenter.getNumberOfPets());
        return ResponseEntity.ok().body(adoptionCenterDTO);
    }

    @PostMapping
    public ResponseEntity<AdoptionCenterIdDTO> createAdoptionCenter(@RequestBody AdoptionCenterDTO request, UriComponentsBuilder uriComponentsBuilder) {
        AdoptionCenterIdDTO adoptionCenterIdDTO = this.adoptionCenterService.createAdoptionCenter(request);

        var uri = uriComponentsBuilder.path("/events/{id}").buildAndExpand(adoptionCenterIdDTO.id()).toUri();

        return ResponseEntity.created(uri).body(adoptionCenterIdDTO);
    }
}

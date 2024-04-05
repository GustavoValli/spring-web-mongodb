package com.valligustavo.springwebmongodb.controllers;

import com.valligustavo.springwebmongodb.domain.adoptioncenter.AdoptionCenter;
import com.valligustavo.springwebmongodb.services.AdoptionCenterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

package io.github.rafaelcmr.controller;

import io.github.rafaelcmr.domain.Demand;
import io.github.rafaelcmr.dto.DemandDTO;
import io.github.rafaelcmr.service.DemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demands")
public class DemandsController {

    @Autowired
    DemandService service;

    @GetMapping("/{id}")
    public ResponseEntity<Demand> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findDemandByIdOrThrowBadRequestException(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<Demand>> findAll(){
        return ResponseEntity.ok(service.findAllDemands());
    }

    @PostMapping
    public ResponseEntity<Demand> save(@RequestBody DemandDTO dto){
        return new ResponseEntity<>(service.saveDemand(dto) , HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Demand> update(@RequestBody DemandDTO dto){
        return new ResponseEntity<>(service.updateDemand(dto), HttpStatus.OK);
    }
}

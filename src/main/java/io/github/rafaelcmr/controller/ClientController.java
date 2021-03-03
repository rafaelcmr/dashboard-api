package io.github.rafaelcmr.controller;

import io.github.rafaelcmr.domain.Client;
import io.github.rafaelcmr.dto.ClientDTO;
import io.github.rafaelcmr.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findByIdOrThrowBadRequestException(id));
    }
    @GetMapping("/list")
    public ResponseEntity<List<Client>> listAll(){
        return new ResponseEntity<>(service.listAllClients(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Client> save(@RequestBody ClientDTO clientDTO){
        return new ResponseEntity<>(service.saveClient(clientDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Client> update(@RequestBody ClientDTO clientDTO){
        return ResponseEntity.ok(service.updateClient(clientDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.deleteClientById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

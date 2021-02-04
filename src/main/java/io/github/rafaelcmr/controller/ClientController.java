package io.github.rafaelcmr.controller;

import io.github.rafaelcmr.domain.Client;
import io.github.rafaelcmr.dto.ClientDTO;
import io.github.rafaelcmr.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService service;

    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findByIdOrThrowBadRequestException(id));
    }
    @GetMapping("/list")
    public ResponseEntity<List<Client>> listAll(){
        return new ResponseEntity<>(service.listAllClients(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Client> save(@RequestParam ClientDTO clientDTO){
        return new ResponseEntity<>(service.saveClient(clientDTO), HttpStatus.CREATED);
    }
}

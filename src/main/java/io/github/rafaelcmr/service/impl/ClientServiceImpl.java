package io.github.rafaelcmr.service.impl;

import io.github.rafaelcmr.domain.Client;
import io.github.rafaelcmr.dto.ClientDTO;
import io.github.rafaelcmr.repository.ClientRepository;
import io.github.rafaelcmr.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;

    @Override
    public Client findByIdOrThrowBadRequestException(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Client not found"));
    }
    @Override
    public List<Client> listAllClients() {
        return repository.findAll();
    }
    @Override
    public Client saveClient(ClientDTO clientDTO) {
        return repository.save(Client.builder()
                .name(clientDTO.getName())
                .cellphone(clientDTO.getCellphone())
                .build());
    }
}

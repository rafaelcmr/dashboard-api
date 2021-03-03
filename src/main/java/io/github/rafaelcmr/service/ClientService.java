package io.github.rafaelcmr.service;

import io.github.rafaelcmr.domain.Client;
import io.github.rafaelcmr.dto.ClientDTO;

import java.util.List;

public interface ClientService {

    Client findByIdOrThrowBadRequestException(Long id);
    List<Client> listAllClients();
    Client saveClient(ClientDTO clientDTO);
    Client updateClient(ClientDTO clientDTO);
    void deleteClientById(Long id);
}

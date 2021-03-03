package io.github.rafaelcmr.service.impl;

import io.github.rafaelcmr.domain.Client;
import io.github.rafaelcmr.dto.ClientDTO;
import io.github.rafaelcmr.repository.ClientRepository;
import io.github.rafaelcmr.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository repository;

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
    @Transactional
    public Client saveClient(ClientDTO clientDTO) {
        Client client = new Client(null, clientDTO.getName(), clientDTO.getCellphone());
        return repository.save(client);
    }
    @Override
    @Transactional
    public Client updateClient(ClientDTO clientDTO) {

        Client clientToBeUpdated = findByIdOrThrowBadRequestException(clientDTO.getId());
        clientToBeUpdated.setName(clientDTO.getName());
        clientToBeUpdated.setCellphone(clientDTO.getCellphone());
        return repository.save(clientToBeUpdated);
    }
    @Override
    public void deleteClientById(Long id) {
//        Client clientToBeDeleted = findByIdOrThrowBadRequestException(id);
//        repository.delete(clientToBeDeleted);
        repository.deleteById(id);
    }
}

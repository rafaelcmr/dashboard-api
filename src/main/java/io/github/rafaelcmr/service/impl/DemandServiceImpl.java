package io.github.rafaelcmr.service.impl;

import io.github.rafaelcmr.domain.Client;
import io.github.rafaelcmr.domain.Demand;
import io.github.rafaelcmr.domain.DemandsProducts;
import io.github.rafaelcmr.dto.DemandDTO;
import io.github.rafaelcmr.dto.DemandProductDTO;
import io.github.rafaelcmr.enuns.DemandStatus;
import io.github.rafaelcmr.repository.DemandRepository;
import io.github.rafaelcmr.service.ClientService;
import io.github.rafaelcmr.service.DemandService;
import io.github.rafaelcmr.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DemandServiceImpl implements DemandService {

    @Autowired
    private DemandRepository repository;
    @Autowired
    private ClientService clientService;
    @Autowired
    private ProductService productService;

    @Override
    public Demand findDemandByIdOrThrowBadRequestException(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Demand not found"));
    }

    @Override
    public List<Demand> findAllDemands() {
        return repository.findAll();
    }

    @Override
    public Demand saveDemand(DemandDTO dto) {
        Client client = clientService.findByIdOrThrowBadRequestException(dto.getClient_id());
        Demand demand = repository.save(new Demand(null, client, dto.getTotal(), DemandStatus.ACTIVE));
        List<DemandsProducts> demandsProducts = setDemmandDTOToDemmandProduct(demand, dto.getList());
        demand.setProductsList(demandsProducts);
        return repository.save(demand);
    }

    @Override
    public Demand updateDemand(DemandDTO dto) {
        Demand demandToUpdate = findDemandByIdOrThrowBadRequestException(dto.getId());
        demandToUpdate.setTotal(dto.getTotal());
        demandToUpdate.setStatus(dto.getStatus());
        demandToUpdate.setClient(clientService.findByIdOrThrowBadRequestException(dto.getClient_id()));
        demandToUpdate.setProductsList(setDemmandDTOToDemmandProduct(demandToUpdate, dto.getList()));
        return repository.save(demandToUpdate);
    }

    @Override
    public List<DemandsProducts> setDemmandDTOToDemmandProduct(Demand demand, List<DemandProductDTO> list) {
        if(list.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, "List is empty");
        }

        return list.stream()
                .map( dto-> {
            DemandsProducts demandsProducts = new DemandsProducts();
            demandsProducts.setProduct( productService.findProductOrThrowBadRequestException( dto.getProduct_id() ));
            demandsProducts.setDemand( findDemandByIdOrThrowBadRequestException(demand.getId()));
            demandsProducts.setQuantity(dto.getQuantity());
            return demandsProducts;
        }).collect(Collectors.toList());
    }
}

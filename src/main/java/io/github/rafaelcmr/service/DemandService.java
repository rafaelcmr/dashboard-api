package io.github.rafaelcmr.service;

import io.github.rafaelcmr.domain.Demand;
import io.github.rafaelcmr.domain.DemandsProducts;
import io.github.rafaelcmr.dto.DemandDTO;
import io.github.rafaelcmr.dto.DemandProductDTO;

import java.util.List;

public interface DemandService {

    Demand findDemandByIdOrThrowBadRequestException(Long id);
    List<Demand> findAllDemands();
    Demand saveDemand(DemandDTO dto);
    Demand updateDemand(DemandDTO dto);
    List<DemandsProducts> setDemmandDTOToDemmandProduct(Demand demand, List<DemandProductDTO> list);
}

package io.github.rafaelcmr.dto;

import io.github.rafaelcmr.enuns.DemandStatus;

import java.math.BigDecimal;
import java.util.List;

public class DemandDTO {

    private Long id;
    private Long client_id;
    private BigDecimal total;
    private DemandStatus status;
    private List<DemandProductDTO> list;

    public DemandDTO() {
    }

    public DemandDTO(Long id, Long client_id, BigDecimal total, DemandStatus status) {
        this.id = id;
        this.client_id = client_id;
        this.total = total;
        this.status = status;
    }

    public DemandDTO(Long client_id, BigDecimal total) {
        this.client_id = client_id;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public DemandStatus getStatus() {
        return status;
    }

    public void setStatus(DemandStatus status) {
        this.status = status;
    }

    public List<DemandProductDTO> getList() {
        return list;
    }

    public void setList(List<DemandProductDTO> list) {
        this.list = list;
    }
}

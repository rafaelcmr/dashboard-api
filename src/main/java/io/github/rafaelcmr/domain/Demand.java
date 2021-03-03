package io.github.rafaelcmr.domain;

import io.github.rafaelcmr.enuns.DemandStatus;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Demand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    private BigDecimal total;
    @OneToMany(mappedBy = "demand")
    private List<DemandsProducts> productsList;
    private DemandStatus status;

    public Demand() {
    }

    public Demand(Long id, Client client, BigDecimal total, List<DemandsProducts> productsList, DemandStatus status) {
        this.id = id;
        this.client = client;
        this.total = total;
        this.productsList = productsList;
        this.status = status;
    }

    public Demand(Long id, Client client, BigDecimal total, DemandStatus status) {
        this.id = id;
        this.client = client;
        this.total = total;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<DemandsProducts> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<DemandsProducts> productsList) {
        this.productsList = productsList;
    }

    public DemandStatus getStatus() {
        return status;
    }

    public void setStatus(DemandStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Demand{" +
                "id=" + id +
                ", client=" + client +
                ", total=" + total +
                ", productsList=" + productsList +
                '}';
    }
}

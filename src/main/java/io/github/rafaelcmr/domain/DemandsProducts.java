package io.github.rafaelcmr.domain;

import javax.persistence.*;

@Entity
public class DemandsProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JoinColumn(name = "product_id")
    @ManyToOne
    private Product product;
    @JoinColumn(name = "demand_id")
    @ManyToOne
    private Demand demand;
    private Long quantity;

    public DemandsProducts() {
    }

    public DemandsProducts(Long id, Product product, Demand demand, Long quantity) {
        this.id = id;
        this.product = product;
        this.demand = demand;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Demand getDemand() {
        return demand;
    }

    public void setDemand(Demand demand) {
        this.demand = demand;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "DemandsProducts{" +
                "id=" + id +
                ", product=" + product +
                ", demand=" + demand +
                ", quantity=" + quantity +
                '}';
    }
}

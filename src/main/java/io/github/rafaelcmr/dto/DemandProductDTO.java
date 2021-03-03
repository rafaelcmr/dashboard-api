package io.github.rafaelcmr.dto;

public class DemandProductDTO {
    private Long product_id;
    private Long quantity;

    public DemandProductDTO() {
    }

    public DemandProductDTO(Long product_id, Long quantity) {
        this.product_id = product_id;
        this.quantity = quantity;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}

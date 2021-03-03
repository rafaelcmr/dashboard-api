package io.github.rafaelcmr.dto;

public class ClientDTO {
    private Long id;
    private String name;
    private String cellphone;

    public ClientDTO(Long id, String name, String cellphone) {
        this.id = id;
        this.name = name;
        this.cellphone = cellphone;
    }

    public ClientDTO(String name, String cellphone) {
        this.name = name;
        this.cellphone = cellphone;
    }

    public ClientDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }
}

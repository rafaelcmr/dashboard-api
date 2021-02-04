package io.github.rafaelcmr.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ClientDTO {
    private Long id;
    private String name;
    private String cellphone;
}

package io.github.rafaelcmr.domain;

import io.github.rafaelcmr.domain.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
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

}

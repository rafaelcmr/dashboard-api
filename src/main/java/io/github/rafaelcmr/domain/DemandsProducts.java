package io.github.rafaelcmr.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
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
}

package io.github.rafaelcmr.repository;

import io.github.rafaelcmr.domain.Demand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandRepository extends JpaRepository<Demand, Long> {
}

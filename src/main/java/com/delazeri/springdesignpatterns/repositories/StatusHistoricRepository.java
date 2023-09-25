package com.delazeri.springdesignpatterns.repositories;

import com.delazeri.springdesignpatterns.domain.StatusHistoric;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StatusHistoricRepository extends JpaRepository<StatusHistoric, UUID> {
}

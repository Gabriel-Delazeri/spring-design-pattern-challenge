package com.delazeri.springdesignpatterns.repositories;

import com.delazeri.springdesignpatterns.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
}

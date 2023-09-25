package com.delazeri.springdesignpatterns.services;

import com.delazeri.springdesignpatterns.domain.Order;
import com.delazeri.springdesignpatterns.domain.Status;
import com.delazeri.springdesignpatterns.domain.dtos.BasicResponse;
import com.delazeri.springdesignpatterns.events.OrderStatusHistoricEvent;
import com.delazeri.springdesignpatterns.repositories.OrderRepository;
import com.delazeri.springdesignpatterns.repositories.StatusHistoricRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository repository;

    @Autowired
    StatusHistoricRepository statusHistoricRepository;

    @Autowired
    ApplicationEventPublisher publisher;

    @Override
    @Transactional
    public BasicResponse createOrder(Order orderData) {
        orderData.setStatus(Status.CREATED);

        Order order = repository.save(orderData);

        publisher.publishEvent(new OrderStatusHistoricEvent(order));

        return new BasicResponse(true, "Order %s created".formatted(order.getId()));
    }

    @Override
    @Transactional
    public BasicResponse completeOrder(UUID orderId) {
        Order orderToBeCompleted = repository.findById(orderId).orElseThrow();

        orderToBeCompleted.setStatus(Status.COMPLETED);

        Order completedOrder = repository.save(orderToBeCompleted);

        publisher.publishEvent(new OrderStatusHistoricEvent(completedOrder));

        return new BasicResponse(true, "Order %s completed".formatted(orderId));
    }

    @Override
    @Transactional
    public BasicResponse cancelOrder(UUID orderId) {
        Order orderToBeCanceled = repository.findById(orderId).orElseThrow();

        orderToBeCanceled.setStatus(Status.CANCELED);

        Order canceledOrder = repository.save(orderToBeCanceled);

        publisher.publishEvent(new OrderStatusHistoricEvent(canceledOrder));

        return new BasicResponse(true, "Order %s canceled".formatted(orderId));
    }
}

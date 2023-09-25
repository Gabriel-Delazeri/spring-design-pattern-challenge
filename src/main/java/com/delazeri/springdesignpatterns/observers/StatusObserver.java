package com.delazeri.springdesignpatterns.observers;

import com.delazeri.springdesignpatterns.domain.StatusHistoric;
import com.delazeri.springdesignpatterns.events.OrderStatusHistoricEvent;
import com.delazeri.springdesignpatterns.repositories.StatusHistoricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class StatusObserver {

    @Autowired
    StatusHistoricRepository repository;

    @EventListener
    public void handleOrderStatusUpdate(OrderStatusHistoricEvent event) {
        StatusHistoric statusHistoric = new StatusHistoric();
        statusHistoric.setOrder(event.getOrder());
        statusHistoric.setCreatedAt(LocalDateTime.now());
        statusHistoric.setStatus(event.getStatus());

        repository.save(statusHistoric);
    }
}

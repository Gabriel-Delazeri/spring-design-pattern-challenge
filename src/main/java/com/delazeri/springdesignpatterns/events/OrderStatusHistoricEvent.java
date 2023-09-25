package com.delazeri.springdesignpatterns.events;

import com.delazeri.springdesignpatterns.domain.Order;
import com.delazeri.springdesignpatterns.domain.Status;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class OrderStatusHistoricEvent extends ApplicationEvent {
    private Order order;
    private Status status;

    public OrderStatusHistoricEvent(Order order) {
        super(Order.class);
        this.status = order.getStatus();
        this.order = order;
    }
}

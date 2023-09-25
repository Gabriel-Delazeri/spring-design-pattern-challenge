package com.delazeri.springdesignpatterns.services;

import com.delazeri.springdesignpatterns.domain.Order;
import com.delazeri.springdesignpatterns.domain.dtos.BasicResponse;

import java.util.UUID;

public interface OrderService {
    BasicResponse createOrder(Order orderData);
    BasicResponse completeOrder(UUID orderId) throws Exception;
    BasicResponse cancelOrder(UUID orderId);
}

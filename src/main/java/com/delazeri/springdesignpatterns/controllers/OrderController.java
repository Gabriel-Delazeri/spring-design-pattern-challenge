package com.delazeri.springdesignpatterns.controllers;

import com.delazeri.springdesignpatterns.domain.Order;
import com.delazeri.springdesignpatterns.domain.dtos.BasicResponse;
import com.delazeri.springdesignpatterns.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/orders")
public class OrderController {

    @Autowired
    OrderService service;

    @PostMapping
    public ResponseEntity<BasicResponse> createOrder(Order orderData) {
        return ResponseEntity.ok(service.createOrder(orderData));
    }

    @PutMapping(value = "/{orderId}/complete")
    public ResponseEntity<BasicResponse> completeOrder(@PathVariable UUID orderId) throws Exception {
        return ResponseEntity.ok(service.completeOrder(orderId));
    }

    @PutMapping(value = "/{orderId}/cancel")
    public ResponseEntity<BasicResponse> cancelOrder(@PathVariable UUID orderId) {
        return ResponseEntity.ok(service.cancelOrder(orderId));
    }

}

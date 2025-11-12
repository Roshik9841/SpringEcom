package com.roshik.SpringEcom.service;

import com.roshik.SpringEcom.model.Order;
import com.roshik.SpringEcom.model.dto.OrderRequest;
import com.roshik.SpringEcom.model.dto.OrderResponse;
import com.roshik.SpringEcom.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderRepo repo;

    public OrderResponse placeOrder(OrderRequest request) {

        Order order = new Order();
        String orderId = "ORD"+ UUID.randomUUID().toString().substring(0,8).toUpperCase();
        order.setOrderId(orderId);

        order.setCustomerName(request.customerName());
        order.setEmail(request.email());

        order.setStatus("placed");

        order.setOrderDate(LocalDate.now());


        return null;
    }


    public List<OrderResponse> getAllOrderResponses() {
        return null;
    }
}

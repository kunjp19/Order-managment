package com.egen.service;

import com.egen.model.Order;

import java.security.Timestamp;
import java.util.List;

public interface OrderService {

        List<Order> getAllOrders();

        Order getOrderById(String id);

        List<Order> getAllOrdersWithInInterval(Timestamp startTime, Timestamp endTime);

        List<Order> top10OrdersWithHighestDollarAmountInZip(String zipcode);

        String cancleOrder(String id);

        Order updateOrder(String id, Order order);

        Order placeOrder(Order order);
}

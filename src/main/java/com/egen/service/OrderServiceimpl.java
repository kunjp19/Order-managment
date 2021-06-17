package com.egen.service;

import com.egen.model.Order;
import com.egen.repository.OrderRepository;
import org.springframework.stereotype.Service;
import java.security.Timestamp;
import java.util.List;

@Service
public class OrderServiceimpl implements OrderService {

    private OrderRepository repository;

    public List<Order> getAllOrders() {
        return repository.getAllOrders();
    }

    @Override
    public Order getOrderById(String id) {
        return null;
    }

    @Override
    public List<Order> getAllOrdersWithInInterval(Timestamp startTime, Timestamp endTime) {

        return null;
    }

    @Override
    public List<Order> top10OrdersWithHighestDollarAmountInZip(String zipcode) {

        return null;
    }
    @Override
    public Order placeOrder(Order order) {
        return null;
    }
    @Override
    public String cancleOrder(String id) {
        return id;

    }

    @Override
    public Order updateOrder(String id, Order order) {
        return order;
    }

}

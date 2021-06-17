package com.egen.repository;

import com.egen.model.Order;

import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.List;


public interface OrderRepository {

    List<Order> getAllOrders();

    Order getOrderById(String id);

    List<Order> getAllOrdersWithInInterval(Timestamp startTime, Timestamp endTime);

    List<Order> top10OrdersWithHighestDollarAmountInZip(String zipcode);

    String cancleOrder(String id);

    Order updateOrder(String id, Order order);

    Order placeOrder(Order order);
}

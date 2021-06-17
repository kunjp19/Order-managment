package com.egen.repository;

import com.egen.exception.ResourceNotFoundException;
import com.egen.model.Order;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Order> getAllOrders() {
        Query query = em.createQuery("SELECT ord FROM Order ord");
        return query.getResultList();
//        orders.add(new Order(order_status: "Placed",order_shipping_charges: 5.12,
//                order_payment_method: "paypal", order_subtotal: 45.13,
//                order_tax:6.17, order_total: 62.45, createdDate:"24/06/2021 - 04:53",
//                modifiedDate: "24/06/2021 - 04:53"));
    }

    @Override
    public Order getOrderById(String id) {
        Query query = em.createQuery("SELECT ord FROM Order ord WHERE ord.id= :order_id").setParameter("order_id",id);
        if(query.getResultList().isEmpty()){
            return null;
        }
        List<Order> orders = query.getResultList();
        return orders.get(0);
    }

    @Override
    public List<Order> getAllOrdersWithInInterval(Timestamp startTime, Timestamp endTime) {
        Query query = em.createQuery("SELECT ord From Order ord WHERE ord.createdDate BETWEEN :startTime AND :endTime")
                .setParameter("startTime",startTime).setParameter("endTime",endTime);
        if(query.getResultList().isEmpty()){
            throw new ResourceNotFoundException("Orders in the given interval not found");
        }
        List<Order> orders = query.getResultList();
        return orders;
    }

    @Override
    public List<Order> top10OrdersWithHighestDollarAmountInZip(String zipcode) {
        Query query = em.createQuery("SELECT ord FROM Order ord,Address adr WHERE ord.shippingAddress=adr.id " +
                "AND adr.zipCode=:zip_code ORDER BY ord.order_total desc").setParameter("zip_code",zipcode);
        if(query.getResultList().isEmpty()){
            return null;
        }
        return query.setMaxResults(10).getResultList();
    }

    public Order cancleOrder(Order order, String id) {
        Order updateOrder = getOrderById(id);
        updateOrder.setOrder_status(order.getOrder_status());
        em.merge(updateOrder);
        return order;
    }

    @Override
    public Order updateOrder(String id, Order order) {
        Order updateOrder = getOrderById(id);
        updateOrder.setOrder_status(order_status.DELIVERED);
        em.merge(updateOrder);
        return updateOrder;
    }

    @Override
    public Order placeOrder(Order order) {
        em.persist(order);
        return order;
    }
}

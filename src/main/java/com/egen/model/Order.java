package com.egen.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "orders")
@NamedQueries({
        @NamedQuery(name="Order.getAllOrders",
                query = "SELECT ord FROM Order ord ORDER BY ord.id ")
        @NamedQuery(name="Order.getOrderById",
                query = "SELECT ord from Order ord WHERE ord.id=:paramOrderId  ")
})
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name = "orderStatus")
    private String order_status;

    @Column(name = "orderShippingCharges")
    private Double order_shipping_charges;

    @Column(name = "orderSubtotal")
    private Double order_subtotal;

    @Column(name = "orderTax")
    private Double order_tax;

    @Column(name = "orderTotal")
    private Double order_total;

    @Column(name = "orderCreatedDate")
    private Timestamp createdDate;

    @Column(name = "orderModifiedDate")
    private Timestamp modifiedDate;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "shipping_id")
    private Address shippingAddress;

    @OneToMany(mappedBy = "orders",targetEntity = Item.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Item> items = new HashSet<Item>();

    @OneToMany(mappedBy = "orders",targetEntity = Payment.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Payment> paymentDetails = new HashSet<Payment>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    public Customer customer;

    public Order() {

    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", order_status='" + order_status + '\'' +
                ", order_shipping_charges=" + order_shipping_charges +
                ", order_subtotal=" + order_subtotal +
                ", order_tax=" + order_tax +
                ", order_total=" + order_total +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                '}';
    }

    public Order(String id, String order_status, Double order_shipping_charges, String order_payment_method, Double order_subtotal, Double order_tax, Double order_total, ZonedDateTime createdDate, ZonedDateTime modifiedDate) {
        this.id = UUID.randomUUID().toString();
        this.order_status = order_status;
        this.order_shipping_charges = order_shipping_charges;
        this.order_subtotal = order_subtotal;
        this.order_tax = order_tax;
        this.order_total = order_total;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public Order(Address shippingAddress) {

        this.shippingAddress = shippingAddress;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public Double getOrder_shipping_charges() {
        return order_shipping_charges;
    }

    public void setOrder_shipping_charges(Double order_shipping_charges) {
        this.order_shipping_charges = order_shipping_charges;
    }


    public Double getOrder_subtotal() {
        return order_subtotal;
    }

    public void setOrder_subtotal(Double order_subtotal) {
        this.order_subtotal = order_subtotal;
    }

    public Double getOrder_tax() {
        return order_tax;
    }

    public void setOrder_tax(Double order_tax) {
        this.order_tax = order_tax;
    }

    public Double getOrder_total() {
        return order_total;
    }

    public void setOrder_total(Double order_total) {
        this.order_total = order_total;
    }

    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public ZonedDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(ZonedDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
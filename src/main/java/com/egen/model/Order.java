package com.egen.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
public class Order {
    @Id
    private String id;
    private String order_customer_id;
    private String order_status;
    private Double order_shipping_charges;
    private String order_payment_method;
    private Double order_subtotal;
    private Double order_tax;
    private Double order_total;
    private ZonedDateTime createdDate;
    private ZonedDateTime modifiedDate;

    public String getOrder_payment_method() {
        return order_payment_method;
    }

    public void setOrder_payment_method(String order_payment_method) {
        this.order_payment_method = order_payment_method;
    }

    public Order(String id, String order_customer_id, String order_status, Double order_shipping_charges, Double order_subtotal, Double order_tax, Double order_total, ZonedDateTime createdDate, ZonedDateTime modifiedDate) {
        this.id = id;
        this.order_customer_id = order_customer_id;
        this.order_status = order_status;
        this.order_shipping_charges = order_shipping_charges;
        this.order_subtotal = order_subtotal;
        this.order_tax = order_tax;
        this.order_total = order_total;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public Order() {
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

    public Order(String id){
        this.id = UUID.randomUUID()
                .toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrder_customer_id() {
        return order_customer_id;
    }

    public void setOrder_customer_id(String order_customer_id) {
        this.order_customer_id = order_customer_id;
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

}

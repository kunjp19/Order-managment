package com.egen.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Shipping {
    @Id
    private String shipping_id;
    private String shipping_addressline1;
    private String shipping_addressline2;
    private String shipping_city;
    private String shipping_state;
    private String shipping_zip;

    // Foreign key
    @OneToOne
    private Order order_customer_id;

    public Order getOrder_customer_id() {
        return order_customer_id;
    }

    public void setOrder_customer_id(Order order_customer_id) {
        this.order_customer_id = order_customer_id;
    }

    public Shipping(String shipping_id, String shipping_addressline1, String shipping_addressline2, String shipping_city, String shipping_state, String shipping_zip) {
        this.shipping_id = shipping_id;
        this.shipping_addressline1 = shipping_addressline1;
        this.shipping_addressline2 = shipping_addressline2;
        this.shipping_city = shipping_city;
        this.shipping_state = shipping_state;
        this.shipping_zip = shipping_zip;
    }

    public Shipping() {

    }

    public String getShipping_id() {
        return shipping_id;
    }

    public void setShipping_id(String shipping_id) {
        this.shipping_id = shipping_id;
    }

    public String getShipping_addressline1() {
        return shipping_addressline1;
    }

    public void setShipping_addressline1(String shipping_addressline1) {
        this.shipping_addressline1 = shipping_addressline1;
    }

    public String getShipping_addressline2() {
        return shipping_addressline2;
    }

    public void setShipping_addressline2(String shipping_addressline2) {
        this.shipping_addressline2 = shipping_addressline2;
    }

    public String getShipping_city() {
        return shipping_city;
    }

    public void setShipping_city(String shipping_city) {
        this.shipping_city = shipping_city;
    }

    public String getShipping_state() {
        return shipping_state;
    }

    public void setShipping_state(String shipping_state) {
        this.shipping_state = shipping_state;
    }

    public String getShipping_zip() {
        return shipping_zip;
    }

    public void setShipping_zip(String shipping_zip) {
        this.shipping_zip = shipping_zip;
    }
}

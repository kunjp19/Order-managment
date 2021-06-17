package com.egen.controller;

import com.egen.model.Order;
import com.egen.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.security.Timestamp;
import java.time.ZonedDateTime;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/orders")

public class OrderController {

    private OrderService service;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Order> getAllOrders(){
        //TODO
        return service.getAllOrders();

//        System.out.println(orders);
//        orders.add(new Order(order_status= "Placed",order_shipping_charges= 5.12,
//                order_payment_method= "paypal", order_subtotal = 45.13,
//                order_tax=6.17, order_total= 62.45, createdDate="24/06/2021 - 04:53",
//                modifiedDate= "24/06/2021 - 04:53"));
    }

    @RequestMapping(method = RequestMethod.GET,value = "/{id}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Order getOrderById(@PathVariable("id") String ordId){
    //TODO
        return service.getOrderById(ordId) ;
    }

    @RequestMapping(method = RequestMethod.GET,value = "/interval",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Order> getAllOrdersWithInInterval(@RequestParam(name = "startTime") Timestamp startTime,
                                                  @RequestParam(name = "endTime") Timestamp endTime){
        //TODO
        return service.getAllOrdersWithInInterval(startTime,endTime);
    }

    @RequestMapping(method = RequestMethod.GET,value = "zip/{zipcode}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Order> top10OrdersWithHighestDollarAmountInZip( @PathVariable String zipcode){
        //TODO
        return service.top10OrdersWithHighestDollarAmountInZip(zipcode);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/placeorder",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Order placeOrder(@RequestBody Order order){
        return service.placeOrder(order);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/cancel/{id}",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String cancelOrder(@PathVariable("id") String ordId){
        return service.cancleOrder(ordId);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/update/{id}",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Order updateOrder(@PathVariable("id") String ordId, @RequestBody Order order){
        return service.updateOrder(ordId, order);
    }
}

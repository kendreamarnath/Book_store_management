package com.test.OrderService.service;

import com.test.OrderService.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();

    Order getOrderById(long id);
    Order createOrder(Order order);
    Order updateOrder(long id, Order order);
    void deleteOrder(long id);
    int getStockByBookId(long id);

}

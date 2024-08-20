package com.test.OrderService.service;

import com.test.OrderService.client.BookClient;
import com.test.OrderService.exception.OrderNotFoundException;
import com.test.OrderService.exception.OutOfStockException;
import com.test.OrderService.model.Order;
import com.test.OrderService.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
public class OrderServiceImp{

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    BookClient bookClient;

//@Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }


    public Order getOrderById(int id) {
        return orderRepository.findById((long) id).orElseThrow(() -> new OrderNotFoundException("Order not found"));
    }


    public Order createOrder(Order order) {
        int stock = bookClient.getStock(order.getBookId());
        if (stock < order.getQuantity()) {
            throw new OutOfStockException("Out of stock");
        }
        return orderRepository.save(order);
    }


    public Order updateOrder(int id, Order order) {
        Order existingOrder = orderRepository.findById((long) id).orElseThrow(() -> new OrderNotFoundException("Order not found"));
        existingOrder.setBookId(order.getBookId());
        existingOrder.setQuantity(order.getQuantity());
        return orderRepository.save(existingOrder);
    }


    public void deleteOrder(int id) {
        Order order = orderRepository.findById(Long.valueOf(id)).orElseThrow(() -> new OrderNotFoundException("Order not found"));
        orderRepository.delete(order);
    }


    public int getStockByBookId(int id) {
        return bookClient.getStockFromBookId(id);
    }


}

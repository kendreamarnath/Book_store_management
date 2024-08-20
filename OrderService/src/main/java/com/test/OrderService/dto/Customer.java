package com.test.OrderService.dto;

public record Customer(
        long id,
        String  name,
        String email,
        String phoneNumber) {
}
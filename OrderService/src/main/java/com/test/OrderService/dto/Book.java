package com.test.OrderService.dto;

public record Book(
        long id,
        String title,
        String author,
        long price,
        long stock){

}
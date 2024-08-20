package com.test.OrderService.dto.CombinedDto;

import com.test.OrderService.dto.Customer;
import com.test.OrderService.dto.OrderDto;

public record CombinedDto(OrderDto order, Customer customer) {
}
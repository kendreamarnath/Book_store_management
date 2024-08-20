package com.test.OrderService.dto.OrderDto;

import com.test.OrderService.model.Status;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public record OrderDto(

        long id,
        @NotNull(message = "CustomerID required")
        long customerId,
        @NotNull(message = "BookID required")
        long bookId,
        @NotNull(message = "Quantity required") @Positive(message = "Positive quantity required")
        int quantity,
        @NotNull(message = "Status Required")  @Pattern(regexp = " PENDING|CONFIRMED|CANCELLED",message =" PENDING, CONFIRMED, CANCELLED   any one of this required" )
        Status status
) {
    public static OrderDto toDto(com.test.OrderService.model.Order.Order order){
        return new OrderDto(order.getId(),order.getCustomerId(), order.getBookId(),order.getQuantity(),order.getStatus());
    }

    public com.test.OrderService.model.Order.Order toOrder(OrderDto dto){
        return new com.test.OrderService.model.Order.Order(dto.customerId, dto.bookId,dto.quantity,dto.status);
    }

}
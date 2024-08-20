package com.test.OrderService.model.Order;


import com.test.OrderService.model.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long customerId;
    private long bookId;
    private  int quantity;
    private Status status;

    public Order(long customerId, long bookId, int quantity, Status status) {
        this.customerId = customerId;
        this.bookId = bookId;
        this.quantity = quantity;
        this.status = status;
    }

}
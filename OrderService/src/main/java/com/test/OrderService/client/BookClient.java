package com.ust.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "book-service")
public interface BookServiceClient {
    @GetMapping("books/{id}/stocks")
    int getStockFromBookId(@PathVariable long id);
    @PutMapping("books/{id}/stock")
    void updateStock(@PathVariable long id, @RequestBody int stockBookId);
}
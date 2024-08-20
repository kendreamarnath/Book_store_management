package com.test.BookService.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record BookDto(

//        @NotEmpty
        Long id,
//        @NotEmpty
        String title,
//        @NotEmpty
        String author,

//        @NotNull
        Integer price,
//        @NotNull
        Integer stock
) {



}

package com.test.CustomerService.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class CustomerDto {
        @Getter
        @NotNull
        private Long id;

        @Getter
        @NotEmpty
        private String name;

        @Getter
        @NotEmpty
        @Email
        private String email;

        @Getter
        @NotEmpty
        private String phone;

        public CustomerDto(Long id, String name, String email, String phone) {
        }


        // Constructors, Getters, and Setters
}

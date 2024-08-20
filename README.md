# Bookstore Management System

## Overview

This project implements a **Bookstore Management System** using a microservices architecture. The system is designed to manage books, orders, and customers with separate services communicating via REST APIs. Service discovery is handled using Eureka, and inter-service communication is facilitated with OpenFeign.

## Architecture

The system is composed of the following services:

1. **Book Service**: Manages book details including title, author, price, and stock.
2. **Order Service**: Manages customer orders, checking book stock availability through the Book Service before placing orders.
3. **Customer Service**: Manages customer information.
4. **Discovery Service**: A Eureka-based service that handles service registration and discovery.

## Technologies Used

- **Spring Boot**: For building microservices.
- **Spring Data JPA**: For data persistence.
- **OpenFeign**: For inter-service communication.
- **Eureka**: For service discovery.
- **H2 Database**: (or any other database) for data storage.

## Services

### 1. Book Service

- **Responsibilities**:
  - Manage book data (CRUD operations).
  - Maintain stock levels.
  - Expose REST endpoints to manage books.

- **Entities**:
  - **Book**: Represents a book with `id`, `title`, `author`, `price`, and `stock`.

- **REST Endpoints**:
  - `GET /books`: List all books
  - `GET /books/{id}`: Get details of a specific book
  - `POST /books`: Add a new book
  - `PUT /books/{id}`: Update book details
  - `DELETE /books/{id}`: Remove a book

### 2. Order Service

- **Responsibilities**:
  - Manage customer orders.
  - Check book availability with the Book Service using OpenFeign before placing an order.
  - Expose REST endpoints to manage orders.

- **Entities**:
  - **Order**: Represents an order with `id`, `customerId`, `bookId`, `quantity`, and `status`.

- **REST Endpoints**:
  - `GET /orders`: List all orders
  - `GET /orders/{id}`: Get details of a specific order
  - `POST /orders`: Place a new order
  - `PUT /orders/{id}`: Update order details
  - `DELETE /orders/{id}`: Cancel an order

- **Feign Client**:
  - Used to communicate with the Book Service for stock checks.

### 3. Customer Service

- **Responsibilities**:
  - Manage customer data.
  - Expose REST endpoints to manage customers.

- **Entities**:
  - **Customer**: Represents a customer with `id`, `name`, `email`, and `phoneNumber`.

- **REST Endpoints**:
  - `GET /customers`: List all customers
  - `GET /customers/{id}`: Get details of a specific customer
  - `POST /customers`: Add a new customer
  - `PUT /customers/{id}`: Update customer details
  - `DELETE /customers/{id}`: Remove a customer

### 4. Discovery Service

- **Responsibilities**:
  - Use Eureka Server to enable service registration and discovery.
  - Ensure that Book, Order, and Customer Services can register with Eureka and discover each other.

## Validations

- **Book Entity**:
  - `title`: Not null/empty, length constraint (1-255 characters)
  - `author`: Not null/empty, length constraint (1-255 characters)
  - `price`: Not null, positive value, precision constraint (2 decimal places)
  - `stock`: Not null, non-negative

- **Order Entity**:
  - `bookId`: Not null, must exist in Book Service
  - `quantity`: Not null, positive value, stock availability
  - `status`: Not null, valid status (e.g., "PENDING", "CONFIRMED", "CANCELLED")

## Implementation Steps

1. **Set up the Eureka Discovery Service**:
   - Create a Spring Boot application with the Eureka Server dependency.
   - Enable Eureka Server in the application.

2. **Develop the Book Service**:
   - Create a Spring Boot application.
   - Use Spring Data JPA for persistence.
   - Expose REST endpoints for CRUD operations on books.
   - Register the service with Eureka.

3. **Develop the Order Service**:
   - Create a Spring Boot application.
   - Use Spring Data JPA for persistence.
   - Implement a Feign Client to communicate with the Book Service.
   - Expose REST endpoints for managing orders.
   - Register the service with Eureka.

4. **Develop the Customer Service**:
   - Create a Spring Boot application.
   - Use Spring Data JPA for persistence.
   - Expose REST endpoints for managing customers.
   - Register the service with Eureka.

5. **Test the System**:
   - Use tools like Postman to test the APIs.
   - Ensure the Order Service can check stock with the Book Service before placing an order.
   - Verify service registration and discovery with Eureka.

## Expected Outcomes

- Mastery of Spring REST API development.
- Proficiency in Spring Data JPA for data persistence.
- Practical experience with OpenFeign for inter-service communication.
- Understanding of Eureka-based service discovery.

## Getting Started

1. Clone the repository:
   ```bash
   git clone https://github.com/your-repo/bookstore-management-system.git




Navigate to each service directory and run:

bash
Copy code
./mvnw spring-boot:run
Ensure Eureka Server is running at http://localhost:8761 to view registered services.

Use Postman or another API tool to interact with the services.

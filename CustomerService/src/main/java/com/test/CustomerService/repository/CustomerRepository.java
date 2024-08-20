package com.test.CustomerService.repository;

import com.test.CustomerService.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    Customer findById(long id);
    Customer findByName(String name);
    Customer findByEmail(String email);
    Customer findByPhone(String phone);
    boolean existsById(long id);

    void deleteById(Long id);
}

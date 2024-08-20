package com.test.CustomerService.service;

import com.test.CustomerService.dto.CustomerDto;
import com.test.CustomerService.exception.CustomerNotFoundException;
import com.test.CustomerService.model.Customer;
import com.test.CustomerService.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void addCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setId(customerDto.getId());
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setPhone(customerDto.getPhone());
        customerRepository.save(customer);
    }

    public void deleteCustomer(Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
        } else {
            throw new CustomerNotFoundException("Customer not found with id: " + id);
        }
    }

    public void updateCustomer(Long id, CustomerDto customerDto) {
        Optional<Customer> customerOptional = Optional.ofNullable(customerRepository.findById(id));
        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            customer.setName(customerDto.getName());
            customer.setEmail(customerDto.getEmail());
            customer.setPhone(customerDto.getPhone());
            customerRepository.save(customer);
        } else {
            throw new CustomerNotFoundException("Customer not found with id: " + id);
        }
    }

    public CustomerDto getCustomer(Long id) {
        Optional<Customer> customerOptional = Optional.ofNullable(customerRepository.findById(id));
        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            return new CustomerDto(customer.getId(), customer.getName(), customer.getEmail(), customer.getPhone());
        } else {
            throw new CustomerNotFoundException("Customer not found with id: " + id);
        }
    }

    public List<CustomerDto> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(customer -> new CustomerDto(customer.getId(), customer.getName(), customer.getEmail(), customer.getPhone()))
                .collect(Collectors.toList());
    }
}

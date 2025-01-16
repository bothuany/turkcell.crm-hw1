package com.turkcell.crm_hw1.controllers;

import com.turkcell.crm_hw1.dtos.customer.CreateCustomerDto;
import com.turkcell.crm_hw1.dtos.customer.GetAllCustomersDto;
import com.turkcell.crm_hw1.dtos.customer.UpdateCustomerDto;
import com.turkcell.crm_hw1.entity.Customer;
import com.turkcell.crm_hw1.services.concretes.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) { this.customerService = customerService; }

    @PostMapping
    public void add(@RequestBody CreateCustomerDto createCustomerDto)
    {
        this.customerService.add(createCustomerDto);
    }

    @GetMapping
    public List<GetAllCustomersDto> getAll() {
        return this.customerService.getAll();
    }

    @PutMapping
    public void update(@RequestBody UpdateCustomerDto updateCustomerDto)
    {
        this.customerService.update(updateCustomerDto);
    }

    @DeleteMapping
    public void delete(@RequestParam String id) {
        this.customerService.delete(id);
    }

    @GetMapping("/findById/{id}")
    public Optional<Customer> getById(@PathVariable String id) {
        return customerService.findById(id);
    }
}

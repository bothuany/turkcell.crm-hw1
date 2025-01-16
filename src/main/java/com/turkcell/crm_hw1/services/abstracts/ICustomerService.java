package com.turkcell.crm_hw1.services.abstracts;

import com.turkcell.crm_hw1.dtos.customer.CreateCustomerDto;
import com.turkcell.crm_hw1.dtos.customer.GetAllCustomersDto;
import com.turkcell.crm_hw1.dtos.customer.UpdateCustomerDto;
import com.turkcell.crm_hw1.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    void add(CreateCustomerDto createCustomerDto);
    void update(UpdateCustomerDto updateCustomerDto);
    String delete(String id);
    List<GetAllCustomersDto> getAll();
    Optional<Customer> findById(String id);
}

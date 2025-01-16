package com.turkcell.crm_hw1.controllers;

import com.turkcell.crm_hw1.dtos.customerType.CreateCustomerTypeDto;
import com.turkcell.crm_hw1.dtos.customerType.GetAllCustomerTypesDto;
import com.turkcell.crm_hw1.dtos.customerType.UpdateCustomerTypeDto;
import com.turkcell.crm_hw1.entity.CustomerType;
import com.turkcell.crm_hw1.services.concretes.CustomerTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/api/v1/customer-types")
public class CustomerTypeController {
    private final CustomerTypeService customerTypeService;

    public CustomerTypeController(CustomerTypeService customerTypeService) {
        this.customerTypeService = customerTypeService;
    }

    @PostMapping
    public void add(@RequestBody CreateCustomerTypeDto createCustomerTypeDto)
    {
        this.customerTypeService.add(createCustomerTypeDto);
    }

    @GetMapping
    public List<GetAllCustomerTypesDto> getAll() {
        return this.customerTypeService.getAll();
    }

    @PutMapping
    public void update(@RequestBody UpdateCustomerTypeDto updateCustomerTypeDto)
    {
        this.customerTypeService.update(updateCustomerTypeDto);
    }

    @DeleteMapping
    public void delete(@RequestParam String id) {
        this.customerTypeService.delete(id);
    }

    @GetMapping("/findById/{id}")
    public Optional<CustomerType> getById(@PathVariable String id) {
        return customerTypeService.findById(id);
    }
}

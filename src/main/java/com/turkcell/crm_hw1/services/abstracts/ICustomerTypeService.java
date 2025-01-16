package com.turkcell.crm_hw1.services.abstracts;

import com.turkcell.crm_hw1.dtos.customerType.CreateCustomerTypeDto;
import com.turkcell.crm_hw1.dtos.customerType.GetAllCustomerTypesDto;
import com.turkcell.crm_hw1.dtos.customerType.UpdateCustomerTypeDto;
import com.turkcell.crm_hw1.entity.CustomerType;

import java.util.List;
import java.util.Optional;

public interface ICustomerTypeService {
    void add(CreateCustomerTypeDto createCustomerTypeDto);
    void update(UpdateCustomerTypeDto updateCustomerTypeDto);
    String delete(String id);
    List<GetAllCustomerTypesDto> getAll();
    Optional<CustomerType> findById(String id);
}

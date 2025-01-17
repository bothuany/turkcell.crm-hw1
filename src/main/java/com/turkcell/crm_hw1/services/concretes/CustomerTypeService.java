package com.turkcell.crm_hw1.services.concretes;

import com.turkcell.crm_hw1.dtos.customerType.CreateCustomerTypeDto;
import com.turkcell.crm_hw1.dtos.customerType.GetAllCustomerTypesDto;
import com.turkcell.crm_hw1.dtos.customerType.UpdateCustomerTypeDto;
import com.turkcell.crm_hw1.entity.CustomerType;
import com.turkcell.crm_hw1.repositories.CustomerTypeRepository;
import com.turkcell.crm_hw1.rules.CustomerTypeBusinessRules;
import com.turkcell.crm_hw1.services.abstracts.ICustomerTypeService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerTypeService implements ICustomerTypeService {
    private CustomerTypeBusinessRules businessRules;
    private final CustomerTypeRepository customerTypeRepository;

    public CustomerTypeService(CustomerTypeBusinessRules customerTypeBusinessRules, CustomerTypeRepository customerTypeRepository) {
        this.businessRules = customerTypeBusinessRules;
        this.customerTypeRepository = customerTypeRepository;
    }

    @Override
    public void add(CreateCustomerTypeDto createCustomerTypeDto) {
        businessRules.checkIfCustomerTypeNameExists(createCustomerTypeDto.getName());

        CustomerType customerType = CustomerType.builder()
                .name(createCustomerTypeDto.getName())
                .build();

        customerTypeRepository.save(customerType);
    }

    @Override
    public void update(UpdateCustomerTypeDto updateCustomerTypeDto) {
        businessRules.checkIfCustomerTypeExists(updateCustomerTypeDto.getId());
        
        CustomerType customerType = customerTypeRepository.findById(updateCustomerTypeDto.getId()).get();

        // Check if new name exists but ignore if it's the same customer type
        customerTypeRepository.findByNameIgnoreCase(updateCustomerTypeDto.getName())
                .ifPresent(existingType -> {
                    if (!existingType.getId().equals(updateCustomerTypeDto.getId())) {
                        throw new RuntimeException("Customer type with name '" + updateCustomerTypeDto.getName() + "' already exists");
                    }
                });

        customerType = CustomerType.builder()
                .id(customerType.getId())
                .name(updateCustomerTypeDto.getName())
                .createdDate(customerType.getCreatedDate())
                .updatedDate(LocalDateTime.now())
                .build();

        customerTypeRepository.save(customerType);
    }

    @Override
    public String delete(String id) {
        businessRules.checkIfCustomerTypeExists(id);
        
        CustomerType customerType = customerTypeRepository.findById(id).get();
        customerTypeRepository.delete(customerType);
        return id;
    }

    @Override
    public List<GetAllCustomerTypesDto> getAll() {
        return customerTypeRepository
                .findAll()
                .stream()
                .map(customerType -> GetAllCustomerTypesDto.builder()
                        .id(customerType.getId())
                        .name(customerType.getName())
                        .build())
                .toList();
    }

    @Override
    public Optional<CustomerType> findById(String id) {
        businessRules.checkIfCustomerTypeExists(id);
        return customerTypeRepository.findById(id);
    }
}

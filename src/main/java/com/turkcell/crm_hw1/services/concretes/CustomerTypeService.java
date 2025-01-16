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
        CustomerType customerType = new CustomerType();
        customerType.setTypeName(createCustomerTypeDto.getTypeName());
        customerType.setCreatedDate(LocalDateTime.now());

        customerTypeRepository.save(customerType);
    }

    @Override
    public void update(UpdateCustomerTypeDto updateCustomerTypeDto) {
        CustomerType customerTypeWithSameId = customerTypeRepository.findById(updateCustomerTypeDto.getId())
                .orElse(null);

        if(customerTypeWithSameId == null)
            throw new RuntimeException("Customer type doesn't exist");

        customerTypeWithSameId.setTypeName(updateCustomerTypeDto.getTypeName());
        customerTypeWithSameId.setUpdatedDate(LocalDateTime.now());
        customerTypeRepository.save(customerTypeWithSameId);
    }

    @Override
    public String delete(String id) {
        CustomerType customerTypeWithSameId = customerTypeRepository.findById(id)
                .orElse(null);

        if(customerTypeWithSameId == null)
            throw new RuntimeException("Customer type doesn't exist");

        customerTypeRepository.delete(customerTypeWithSameId);
        return id;
    }

    @Override
    public List<GetAllCustomerTypesDto> getAll() {
        List<GetAllCustomerTypesDto> getAllCustomerTypesDtos = customerTypeRepository
                .findAll()
                .stream()
                .map((customerType) -> new GetAllCustomerTypesDto(customerType.getTypeName()))
                .toList();

        return getAllCustomerTypesDtos;
    }

    @Override
    public Optional<CustomerType> findById(String id) {
        CustomerType customerType = customerTypeRepository.findById(id)
                .orElse(null);

        if(customerType == null)
            throw new RuntimeException("Customer type does not exist");
        return Optional.of(customerType);
    }
}

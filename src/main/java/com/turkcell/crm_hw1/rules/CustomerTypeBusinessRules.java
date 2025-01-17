package com.turkcell.crm_hw1.rules;

import com.turkcell.crm_hw1.repositories.CustomerTypeRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerTypeBusinessRules {
    private final CustomerTypeRepository customerTypeRepository;

    public CustomerTypeBusinessRules(CustomerTypeRepository customerTypeRepository) {
        this.customerTypeRepository = customerTypeRepository;
    }

    public void checkIfCustomerTypeExists(String id) {
        if (!customerTypeRepository.existsById(id)) {
            throw new RuntimeException("Customer type does not exist");
        }
    }

    public void checkIfCustomerTypeNameExists(String name) {
        if (customerTypeRepository.findByNameIgnoreCase(name).isPresent()) {
            throw new RuntimeException("Customer type with name '" + name + "' already exists");
        }
    }
}

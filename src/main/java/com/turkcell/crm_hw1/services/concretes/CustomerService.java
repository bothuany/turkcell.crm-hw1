package com.turkcell.crm_hw1.services.concretes;

import com.turkcell.crm_hw1.dtos.customer.CreateCustomerDto;
import com.turkcell.crm_hw1.dtos.customer.GetAllCustomersDto;
import com.turkcell.crm_hw1.dtos.customer.UpdateCustomerDto;
import com.turkcell.crm_hw1.entity.Customer;
import com.turkcell.crm_hw1.entity.CustomerType;
import com.turkcell.crm_hw1.entity.Segment;
import com.turkcell.crm_hw1.repositories.CustomerRepository;
import com.turkcell.crm_hw1.repositories.CustomerTypeRepository;
import com.turkcell.crm_hw1.repositories.SegmentRepository;
import com.turkcell.crm_hw1.rules.CustomerBusinessRules;
import com.turkcell.crm_hw1.services.abstracts.ICustomerService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerBusinessRules customerBusinessRules;
    private final CustomerTypeRepository customerTypeRepository;
    private final SegmentRepository segmentRepository;

    public CustomerService(CustomerRepository customerRepository, CustomerBusinessRules customerBusinessRules, CustomerTypeRepository customerTypeRepository, SegmentRepository segmentRepository) {
        this.customerRepository = customerRepository;
        this.customerBusinessRules = customerBusinessRules;
        this.customerTypeRepository = customerTypeRepository;
        this.segmentRepository = segmentRepository;
    }

    @Override
    public void add(CreateCustomerDto createCustomerDto) {
        customerBusinessRules.customerTypeMustExist(createCustomerDto.getTypeId());
        customerBusinessRules.segmentMustExist(createCustomerDto.getSegmentId());

        CustomerType customerType = customerTypeRepository.findById(createCustomerDto.getTypeId())
                .orElse(null);

        Segment segment = segmentRepository.findById(createCustomerDto.getSegmentId())
                .orElse(null);

        Customer customer = Customer.builder()
                .firstName(createCustomerDto.getFirstName())
                .lastName(createCustomerDto.getLastName())
                .address(createCustomerDto.getAddress())
                .contact(createCustomerDto.getContact())
                .identityNo(createCustomerDto.getIdentityNo())
                .type(customerType)
                .segment(segment)
                .build();

        customerRepository.save(customer);
    }

    @Override
    public void update(UpdateCustomerDto updateCustomerDto) {
        customerBusinessRules.customerTypeMustExist(updateCustomerDto.getTypeId());
        customerBusinessRules.segmentMustExist(updateCustomerDto.getSegmentId());

        CustomerType customerType = customerTypeRepository.findById(updateCustomerDto.getTypeId())
                .orElse(null);

        Segment segment = segmentRepository.findById(updateCustomerDto.getSegmentId())
                .orElse(null);

        Customer customerWithSameIdentity = customerRepository.findCustomerByIdentityNoIs(updateCustomerDto.getIdentityNo())
                .orElse(null);

        if(customerWithSameIdentity != null)
            throw new RuntimeException("Customer already exists");

        Customer customerToUpdate = customerRepository.findById(updateCustomerDto.getId()).orElseThrow(() -> new RuntimeException("Customer not found"));
        
        customerToUpdate = Customer.builder()
                .id(customerToUpdate.getId())
                .firstName(updateCustomerDto.getFirstName())
                .lastName(updateCustomerDto.getLastName())
                .address(updateCustomerDto.getAddress())
                .contact(updateCustomerDto.getContact())
                .identityNo(updateCustomerDto.getIdentityNo())
                .type(customerType)
                .segment(segment)
                .createdDate(customerToUpdate.getCreatedDate())
                .updatedDate(LocalDateTime.now())
                .build();

        customerRepository.save(customerToUpdate);
    }

    @Override
    public String delete(String id) {
        Customer customer = customerRepository.findById(id)
                .orElse(null);

        if(customer == null)
            throw new RuntimeException("Customer does not exist");

        customerBusinessRules.customerTypeMustExist(customer.getType().getId());
        customerBusinessRules.segmentMustExist(customer.getSegment().getId());

        customerRepository.delete(customer);
        return id;
    }

    @Override
    public List<GetAllCustomersDto> getAll() {
        return customerRepository
                .findAll()
                .stream()
                .map(customer -> GetAllCustomersDto.builder()
                        .id(customer.getId())
                        .firstName(customer.getFirstName())
                        .lastName(customer.getLastName())
                        .address(customer.getAddress())
                        .contact(customer.getContact())
                        .identityNo(customer.getIdentityNo())
                        .typeId(customer.getType().getId())
                        .segmentId(customer.getSegment().getId())
                        .build())
                .toList();
    }

    @Override
    public Optional<Customer> findById(String id) {
        Customer customer = customerRepository.findById(id)
                .orElse(null);

        if(customer == null)
            throw new RuntimeException("Customer does not exist");
        return Optional.of(customer);
    }
}

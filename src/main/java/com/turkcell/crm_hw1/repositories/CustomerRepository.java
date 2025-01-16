package com.turkcell.crm_hw1.repositories;

import com.turkcell.crm_hw1.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, String> {
    Optional<Customer> findCustomerByIdentityNoIs(String identityNo);
}

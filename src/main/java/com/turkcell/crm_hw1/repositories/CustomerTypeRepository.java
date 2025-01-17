package com.turkcell.crm_hw1.repositories;

import com.turkcell.crm_hw1.entity.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerTypeRepository extends JpaRepository<CustomerType, String> {
    Optional<CustomerType> findByNameIgnoreCase(String name);
}

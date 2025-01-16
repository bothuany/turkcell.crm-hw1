package com.turkcell.crm_hw1.repositories;

import com.turkcell.crm_hw1.entity.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerTypeRepository extends JpaRepository<CustomerType, String> {
}

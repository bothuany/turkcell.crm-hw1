package com.turkcell.crm_hw1.dtos.customer;

import com.turkcell.crm_hw1.entity.CustomerType;
import com.turkcell.crm_hw1.entity.Segment;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CreateCustomerDto {


    private int id;

    private String firstName;

    private String lastName;

    private String address;

    private String contact;

    private String identityNo;

    private CustomerType type;

    private Segment segment;

}

package com.turkcell.crm_hw1.dtos.customer;


import com.turkcell.crm_hw1.entity.CustomerType;
import com.turkcell.crm_hw1.entity.Segment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdateCustomerDto {


    private int id;

    private String firstName;

    private String lastName;

    private String address;

    private String contact;

    private String identityNo;

    private CustomerType type;

    private Segment segment;
}

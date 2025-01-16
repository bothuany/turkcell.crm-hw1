package com.turkcell.crm_hw1.dtos.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.turkcell.crm_hw1.dtos.customerType.GetAllCustomerTypesDto;
import com.turkcell.crm_hw1.dtos.segment.GetAllSegmentsDto;

public class GetAllCustomersDto {
    @JsonProperty
    private String id;

    @JsonProperty
    private String firstName;

    @JsonProperty
    private String lastName;

    private String address;

    private String contact;

    private String identityNo;

    private GetAllCustomerTypesDto type;

    private GetAllSegmentsDto segment;

    public GetAllCustomersDto(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

}

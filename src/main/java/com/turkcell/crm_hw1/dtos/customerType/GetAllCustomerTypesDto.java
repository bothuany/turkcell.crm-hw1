package com.turkcell.crm_hw1.dtos.customerType;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
public class GetAllCustomerTypesDto {
    private String id;

    @JsonProperty
    private String typeName;

    private String createdDate;

    private String updatedDate;

    public GetAllCustomerTypesDto(String typeName) {
        this.typeName = typeName;
    }
}

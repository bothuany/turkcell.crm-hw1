package com.turkcell.crm_hw1.dtos.customerType;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAllCustomerTypesDto {
    private String id;
    private String name;
}

package com.turkcell.crm_hw1.dtos.customerType;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GetAllCustomerTypesDto {
    private String id;
    private String typeName;
    private String createdDate;
    private String updatedDate;
}

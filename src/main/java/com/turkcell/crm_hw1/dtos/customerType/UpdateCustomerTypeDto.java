package com.turkcell.crm_hw1.dtos.customerType;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UpdateCustomerTypeDto {
    private String id; // maybe will change
    private String typeName;
    private String createdDate;
    private String updatedDate;
}

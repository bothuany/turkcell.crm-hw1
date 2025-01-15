package com.turkcell.crm_hw1.dtos.customerType;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UpdateCustomerTypeDto {
    @NotNull
    private String id; // maybe will change
    @NotNull
    private String typeName;
    private String createdDate;
    private String updatedDate;
}

package com.turkcell.crm_hw1.dtos.customerType;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateCustomerTypeDto {
    @NotNull
    private String typeName;
    private String createdDate;
    private String updatedDate;
}

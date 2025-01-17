package com.turkcell.crm_hw1.dtos.customerType;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCustomerTypeDto {
    @NotNull
    @JsonProperty
    private String id;

    @NotNull
    @Size(min = 1, max = 20)
    private String name;
}

package com.turkcell.crm_hw1.dtos.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCustomerDto {
    @NotNull
    @Size(min = 1, max = 20)
    private String firstName;

    @NotNull
    @Size(min = 1, max = 20)
    private String lastName;

    @Size(min = 1, max = 200)
    private String address;

    @Size(min = 1, max = 200)
    private String contact;

    @NotNull
    @Size(min = 1, max = 20)
    private String identityNo;

    @NotNull
    private String typeId;

    @NotNull
    private String segmentId;
}

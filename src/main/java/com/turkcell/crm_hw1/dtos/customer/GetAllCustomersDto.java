package com.turkcell.crm_hw1.dtos.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAllCustomersDto {
    private String id;
    private String firstName;
    private String lastName;
    private String address;
    private String contact;
    private String identityNo;
    private String typeId;
    private String segmentId;
}

package com.turkcell.crm_hw1.dtos.segment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetAllSegmentsDto {
    private String id;
    private String name;
}

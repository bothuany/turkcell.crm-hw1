package com.turkcell.crm_hw1.dtos.segment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetSegmentByIdDto {
    private String id;
    private String name;
}

package com.turkcell.crm_hw1.dtos.segment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetSegmentByIdDto {

    private String id;
    private String name;
}

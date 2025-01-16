package com.turkcell.crm_hw1.dtos.segment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GetAllSegmentsDto {
    private String id;

    @JsonProperty
    private String name;

    public GetAllSegmentsDto(String name) {
        this.name = name;
    }
}

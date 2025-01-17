package com.turkcell.crm_hw1.dtos.segment;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateSegmentDto {
    @NotNull
    @Size(min = 1, max = 20)
    private String name;
}

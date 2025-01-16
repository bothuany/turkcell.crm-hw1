package com.turkcell.crm_hw1.dtos.customerType;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
public class UpdateCustomerTypeDto {
    @NotNull
    private String id;
    @NotNull
    private String typeName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}

package com.turkcell.crm_hw1.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "FeedbackType")
public class FeedbackType extends BaseEntity {
    @Column(name = "type_name")
    private String typeName;
}

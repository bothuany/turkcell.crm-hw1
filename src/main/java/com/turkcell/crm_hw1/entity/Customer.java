package com.turkcell.crm_hw1.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name="customers")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Customer extends BaseEntity {
    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="address")
    private String address;

    @Column(name="contact")
    private String contact;

    @Column(name="identity_no")
    private String identityNo;

    @ManyToOne()
    @JoinColumn(name="type_id")
    private CustomerType type;

    @ManyToOne()
    @JoinColumn(name="segment_id")
    private Segment segment;
}

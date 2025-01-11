package com.turkcell.crm_hw1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "payment_method")
public class PaymentMethod {
    @Column(name = "payment_method_name")
    private String paymentMethodName;

    @OneToMany(mappedBy = "paymentMethod")
    private List<Subscription> subscriptions;
}

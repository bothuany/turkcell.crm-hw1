package com.turkcell.crm_hw1.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "permission")
public class Permission {
    @Column(name = "description")
    private String description;

    @ManyToMany
    @JoinTable(name = "role_permission",
            joinColumns = @JoinColumn(name = "permission_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;
}

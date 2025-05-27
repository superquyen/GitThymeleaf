package com.data.entity;

import jakarta.persistence.*;
import lombok.Data;

@Table
@Data
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fullName;
    private String email;
    private String phone;
    private String password;
    private String address;
    private String username;
    private String role;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}

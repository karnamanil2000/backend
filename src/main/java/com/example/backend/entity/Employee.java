package com.example.backend.entity;

import jakarta.persistence.*;

import lombok.*;

@Data
@Entity
@Table(name = "employees_details")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String email;
}

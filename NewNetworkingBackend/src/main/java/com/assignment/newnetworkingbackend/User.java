package com.assignment.newnetworkingbackend;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity // Tells Hibernate to treat this class as a database table
@Table(name = "users") // Names the table "users" in PostgreSQL
public class User {

    // Getters and Setters...
    @Id // Defines the Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tells Hibernate to use PostgreSQL's SERIAL/BIGSERIAL auto-increment
    private Long id;

    @Column(unique = true, nullable = false) // Generates a UNIQUE and NOT NULL constraint
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    // Standard boilerplate (Must have an empty constructor for Hibernate)
    public User() {}

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

}

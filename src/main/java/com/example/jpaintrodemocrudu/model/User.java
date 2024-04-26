package com.example.jpaintrodemocrudu.model;

import com.example.jpaintrodemocrudu.enums.UserStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String email;

    @Column(name = "name")
    private String userName;

    private String surName;

    @Enumerated(EnumType.STRING)
    private UserStatus status;



}

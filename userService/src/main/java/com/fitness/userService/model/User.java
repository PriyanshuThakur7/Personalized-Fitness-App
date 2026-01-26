package com.fitness.userService.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private String id;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private String Name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private int weight;

    private int height;

    @Enumerated(EnumType.STRING)
    private Goal goal;

}

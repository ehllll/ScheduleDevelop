package com.example.scheduledevelop.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String username;
    private String email;



    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public User() {}

    public void update(String username, String email) {
        this.username = username;
        this.email = email;
    }

}

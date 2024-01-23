package com.deceptiveb.movies.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table
public class AppUser {

    @Id
    @SequenceGenerator(
            name = "user_id_sequence",
            sequenceName = "user_id_sequence"
    )
    @GeneratedValue(
            generator = "user_id_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Integer id;

    @NotBlank
    private String username;

    @NotBlank
    @Email
    private String email;

    public AppUser() {
    }

    public AppUser(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public AppUser(Integer id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

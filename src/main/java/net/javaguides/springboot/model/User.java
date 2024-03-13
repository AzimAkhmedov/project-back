package net.javaguides.springboot.model;

import jakarta.persistence.*;
@Entity
@Table(name = "users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "fullname")
    private String 	fullName;

    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role;


    public User() {

    }

    public User(String fullName, String password, String role) {
        super();
        this.fullName = fullName;
        this.password = password;
        this.role = role;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}



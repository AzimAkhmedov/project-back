package net.javaguides.springboot.model;
import jakarta.persistence.*;
@Entity
@Table(name = "users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "fullname")
    private String 	fullname;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role;
    @Column(name = "passportNumber")
    private String passportNumber;
    @Column(name = "citizenship")
    private String citizenship;

    public User() {

    }

    public User(String fullname, String password, String role, String passportNumber, String citizenship) {
        super();
    }

    public User(long id, String fullname, String password, String role, String passportNumber, String citizenship) {
        this.id = id;
        this.fullname = fullname;
        this.password = password;
        this.role = role;
        this.passportNumber = passportNumber;
        this.citizenship = citizenship;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }
}



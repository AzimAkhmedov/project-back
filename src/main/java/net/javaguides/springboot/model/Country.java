package net.javaguides.springboot.model;
import jakarta.persistence.*;
@Entity
@Table(name = "countries")

public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long countryID;
    @Column(name = "countryName")
    private String countryName;

    public Country() {
    }

    public Country(long countryID, String countryName) {
        this.countryID = countryID;
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}

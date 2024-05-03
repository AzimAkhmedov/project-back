package net.javaguides.springboot.model;
import jakarta.persistence.*;
@Entity
@Table(name = "countries")

public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long countryID;

    @Column(name = "countryCode")
    private String countryCode;

    @Column(name = "countryName")
    private String countryName;

    public Country() {
    }

    public Country(String countryCode, String countryName){
        super();
    }

    public Country(long countryID, String countryCode, String countryName) {
        this.countryID = countryID;
        this.countryCode = countryCode;
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}

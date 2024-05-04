package net.javaguides.springboot.model;
import jakarta.persistence.*;
@Entity
@Table(name = "countries")

public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long country_id;

    @Column(name = "country_code")
    private String country_code;

    @Column(name = "country_name")
    private String country_name;

    public Country() {
    }

    public Country(String countryCode, String countryName){
        super();
    }

    public Country(long country_id, String country_code, String country_name) {
        this.country_id = country_id;
        this.country_code = country_code;
        this.country_name = country_name;
    }

    public String getCountryCode() {
        return country_code;
    }

    public void setCountryCode(String country_code) {
        this.country_code = country_code;
    }

    public String getCountryName() {
        return country_name;
    }

    public void setCountryName(String country_name) {
        this.country_name = country_name;
    }
}

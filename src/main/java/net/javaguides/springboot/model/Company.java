package net.javaguides.springboot.model;
import jakarta.persistence.*;
@Entity
@Table(name = "companies")

public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long companyID;
    @Column(name = "companyName")
    private String companyName;
    @Column(name = "countryID")
    private long countryID;

    public Company() {
    }

    public Company(String companyName, long countryID){
        super();
    }

    public Company(long companyID, String companyName, long countryID) {
        this.companyID = companyID;
        this.companyName = companyName;
        this.countryID = countryID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public long getCountryID() {
        return countryID;
    }

    public void setCountryID(long countryID) {
        this.countryID = countryID;
    }
}

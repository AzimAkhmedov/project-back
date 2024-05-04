package net.javaguides.springboot.model;
import jakarta.persistence.*;
@Entity
@Table(name = "companies")

public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long company_id;
    @Column(name = "company_name")
    private String company_name;
    @Column(name = "country_id")
    private long country_id;

    public Company() {
    }

    public Company(String companyName, long country_id){
        super();
    }

    public Company(long company_id, String company_name, long country_id) {
        this.company_id = company_id;
        this.company_name = company_name;
        this.country_id = country_id;
    }

    public String getCompanyName() {
        return company_name;
    }

    public void setCompanyName(String company_name) {
        this.company_name = company_name;
    }

    public long getCountryID() {
        return country_id;
    }

    public void setCountryID(long country_id) {
        this.country_id = country_id;
    }
}

package net.javaguides.springboot.model;
import jakarta.persistence.*;
@Entity
@Table(name = "employees")

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userID;
    @Column(name = "companyID")
    private long companyID;

    public Employee() {
    }

    public Employee(long companyID){
        super();
    }

    public Employee(long userID, long companyID) {
        this.userID = userID;
        this.companyID = companyID;
    }

    public long getCompanyID() {
        return companyID;
    }

    public void setCompanyID(long companyID) {
        this.companyID = companyID;
    }
}

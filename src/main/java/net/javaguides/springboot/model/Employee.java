package net.javaguides.springboot.model;
import jakarta.persistence.*;
@Entity
@Table(name = "employees")

public class Employee {
    @Id
    @Column(name = "user_id")
    private long user_id;
    @Column(name = "company_id")
    private long company_id;

    public Employee() {
    }

    public Employee(int user_id,long companyID){
        super();
    }

    public Employee(long user_id, long companyID) {
        this.user_id = user_id;
        this.company_id = companyID;
    }

    public long getCompanyID() {
        return company_id;
    }

    public void setCompanyID(long company_id) {
        this.company_id = company_id;
    }
    public long getUserID(){return  user_id;};
    public void setUserID(long user_id) {
        this.user_id = user_id;
    }

}

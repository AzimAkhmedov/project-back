package net.javaguides.springboot.model;
import jakarta.persistence.*;
@Entity
@Table(name = "flights")

public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long flightID;
    @Column(name = "companyID")
    private long companyID;
    @Column(name = "originID")
    private long originID;
    @Column(name = "destinationID")
    private long destinationID;
    @Column(name = "duration")
    private int duration;
    @Column(name = "availableEconomSeats")
    private int availableEconomSeats;
    @Column(name = "economPrice")
    private int economPrice;
    @Column(name = "availableBusinessSeats")
    private int availableBusinessSeats;
    @Column(name = "businessPrice")
    private int businessPrice;

    public Flight() {
    }

    public Flight(long companyID, long originID, long destinationID, int duration, int availableEconomSeats, int economPrice, int availableBusinessSeats, int businessPrice){
        super();
    }

    public Flight(long flightID, long companyID, long originID, long destinationID, int duration, int availableEconomSeats, int economPrice, int availableBusinessSeats, int businessPrice) {
        this.flightID = flightID;
        this.companyID = companyID;
        this.originID = originID;
        this.destinationID = destinationID;
        this.duration = duration;
        this.availableEconomSeats = availableEconomSeats;
        this.economPrice = economPrice;
        this.availableBusinessSeats = availableBusinessSeats;
        this.businessPrice = businessPrice;
    }

    public long getCompanyID() {
        return companyID;
    }

    public void setCompanyID(long companyID) {
        this.companyID = companyID;
    }

    public long getOriginID() {
        return originID;
    }

    public void setOriginID(long originID) {
        this.originID = originID;
    }

    public long getDestinationID() {
        return destinationID;
    }

    public void setDestinationID(long destinationID) {
        this.destinationID = destinationID;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getAvailableEconomSeats() {
        return availableEconomSeats;
    }

    public void setAvailableEconomSeats(int availableEconomSeats) {
        this.availableEconomSeats = availableEconomSeats;
    }

    public int getEconomPrice() {
        return economPrice;
    }

    public void setEconomPrice(int economPrice) {
        this.economPrice = economPrice;
    }

    public int getAvailableBusinessSeats() {
        return availableBusinessSeats;
    }

    public void setAvailableBusinessSeats(int availableBusinessSeats) {
        this.availableBusinessSeats = availableBusinessSeats;
    }

    public int getBusinessPrice() {
        return businessPrice;
    }

    public void setBusinessPrice(int businessPrice) {
        this.businessPrice = businessPrice;
    }
}

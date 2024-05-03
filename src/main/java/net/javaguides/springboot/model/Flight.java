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
    @Column(name = "originCode")
    private String originCityName;
    @Column(name = "destinationCode")
    private String destinationCityName;
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

    public Flight(long companyID, String originCityName, String destinationCityName, int duration, int availableEconomSeats, int economPrice, int availableBusinessSeats, int businessPrice){
        super();
    }

    public Flight(long flightID, long companyID, String originCityName, String destinationCityName, int duration, int availableEconomSeats, int economPrice, int availableBusinessSeats, int businessPrice) {
        this.flightID = flightID;
        this.companyID = companyID;
        this.originCityName = originCityName;
        this.destinationCityName = destinationCityName;
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

    public String getOriginCityName() {
        return originCityName;
    }

    public void setOriginCityName(String originCityName) {
        this.originCityName = originCityName;
    }

    public String getDestinationCityName() {
        return destinationCityName;
    }

    public void setDestinationCityName(String destinationCityName) {
        this.destinationCityName = destinationCityName;
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

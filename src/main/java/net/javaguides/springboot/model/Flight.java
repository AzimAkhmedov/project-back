package net.javaguides.springboot.model;
import jakarta.persistence.*;
@Entity
@Table(name = "flights")

public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long flight_id;
    @Column(name = "company_id")
    private long company_id;
    @Column(name = "origin_id")
    private long origin_id;
    @Column(name = "destination_id")
    private long destination_id;
    @Column(name = "duration")

    private int duration;
    @Column(name = "departure_date")
    private String departure_date;
    @Column(name = "available_economy_seats")
    private int available_economy_seats;
    @Column(name = "economy_price")
    private int economyPrice;
        @Column(name = "available_business_seats")
    private int available_business_seats;
    @Column(name = "business_price")
    private int businessPrice;

    public Flight() {
    }

    public Flight(long companyID, long origin_id, long destination_id, int duration, String date, int availableEconomySeats, int economyPrice, int availableBusinessSeats, int businessPrice){
        super();
    }

    public Flight(long flight_id, long company_id, long origin_id, long destination_id, int duration, String departure_date, int available_economy_seats, int economyPrice, int available_business_seats, int businessPrice) {
        this.flight_id = flight_id;
        this.company_id = company_id;
        this.origin_id = origin_id;
        this.destination_id = destination_id;
        this.duration = duration;
        this.departure_date = departure_date;
        this.available_economy_seats = available_economy_seats;
        this.economyPrice = economyPrice;
        this.available_business_seats = available_business_seats;
        this.businessPrice = businessPrice;
    }

    public long getFlight_id() {
        return flight_id;
    }

    public long getCompanyID() {
        return company_id;
    }

    public void setCompanyID(long companyID) {
        this.company_id = companyID;
    }

    public long getOriginID() {
        return origin_id;
    }

    public void setOriginID(long origin_id) {
        this.origin_id = origin_id;
    }

    public long getDestinationID() {
        return destination_id;
    }

    public void setDestinationID(long destination_id) {
        this.destination_id = destination_id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDepartureDate() {
        return departure_date;
    }

    public void setDepartureDate(String departure_date) {
        this.departure_date = departure_date;
    }

    public int getAvailableEconomySeats() {
        return available_economy_seats;
    }

    public void setAvailableEconomySeats(int available_economy_seats) {
        this.available_economy_seats = available_economy_seats;
    }

    public int getEconomyPrice() {
        return economyPrice;
    }

    public void setEconomyPrice(int economyPrice) {
        this.economyPrice = economyPrice;
    }

    public int getAvailableBusinessSeats() {
        return available_business_seats;
    }

    public void setAvailableBusinessSeats(int availableBusinessSeats) {
        this.available_business_seats = availableBusinessSeats;
    }

    public int getBusinessPrice() {
        return businessPrice;
    }

    public void setBusinessPrice(int businessPrice) {
        this.businessPrice = businessPrice;
    }
}

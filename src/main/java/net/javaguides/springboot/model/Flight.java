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
    @Column(name = "origin_code")
    private String origin_code;
    @Column(name = "destination_code")
    private String destination_code;
    @Column(name = "duration")
    private int duration;
    @Column(name = "departure_date")
    private String departure_date;
    @Column(name = "available_econom_seats")
    private int available_econom_seats;
    @Column(name = "economPrice")
    private int economPrice;
    @Column(name = "available_business_seats")
    private int available_business_seats;
    @Column(name = "businessPrice")
    private int businessPrice;

    public Flight() {
    }

    public Flight(long companyID, String originCityName, String destinationCityName, int duration, String date, int availableEconomSeats, int economPrice, int availableBusinessSeats, int businessPrice){
        super();
    }

    public Flight(long flight_id, long companyID, String origin_code, String destination_code, int duration, String departure_date, int available_econom_seats, int economPrice, int available_business_seats, int businessPrice) {
        this.flight_id = flight_id;
        this.company_id = companyID;
        this.origin_code = origin_code;
        this.destination_code = destination_code;
        this.duration = duration;
        this.departure_date = departure_date;
        this.available_econom_seats = available_econom_seats;
        this.economPrice = economPrice;
        this.available_business_seats = available_business_seats;
        this.businessPrice = businessPrice;
    }

    public long getCompanyID() {
        return company_id;
    }

    public void setCompanyID(long companyID) {
        this.company_id = companyID;
    }

    public String getOriginCityName() {
        return origin_code;
    }

    public void setOriginCityName(String origin_code) {
        this.origin_code = origin_code;
    }

    public String getDestinationCityName() {
        return destination_code;
    }

    public void setDestinationCityName(String destination_code) {
        this.destination_code = destination_code;
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

    public int getAvailableEconomSeats() {
        return available_econom_seats;
    }

    public void setAvailableEconomSeats(int available_econom_seats) {
        this.available_econom_seats = available_econom_seats;
    }

    public int getEconomPrice() {
        return economPrice;
    }

    public void setEconomPrice(int economPrice) {
        this.economPrice = economPrice;
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

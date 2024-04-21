package net.javaguides.springboot.model;
import jakarta.persistence.*;
@Entity
@Table(name = "bookings")

public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookingID;
    @Column(name = "flightID")
    private long flightID;
    @Column(name = "userID")
    private long userID;
    @Column(name = "paymentID")
    private long paymentID;
    @Column(name = "flightClass")
    private String flightClass;

    public Booking() {
    }

    public Booking(long bookingID, long flightID, long userID, long paymentID, String flightClass) {
        this.bookingID = bookingID;
        this.flightID = flightID;
        this.userID = userID;
        this.paymentID = paymentID;
        this.flightClass = flightClass;
    }

    public long getFlightID() {
        return flightID;
    }

    public void setFlightID(long flightID) {
        this.flightID = flightID;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public long getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(long paymentID) {
        this.paymentID = paymentID;
    }

    public String getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(String flightClass) {
        this.flightClass = flightClass;
    }
}

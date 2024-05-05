package net.javaguides.springboot.model;
import jakarta.persistence.*;
@Entity
@Table(name = "bookings")

public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long booking_id;
    @Column(name = "flight_id")
    private long flight_id;
    @Column(name = "user_id")
    private long user_id;
    @Column(name = "payment_id")
    private long payment_id;
    @Column(name = "flight_class")
    private String flight_class;

    public Booking() {
    }

    public Booking(long flight_id, long userID, long paymentID, String flight_class){
        super();
    }

    public Booking(long booking_id, long flight_id, long user_id, long payment_id, String flight_class) {
        this.booking_id = booking_id;
        this.flight_id = flight_id;
        this.user_id = user_id;
        this.payment_id = payment_id;
        this.flight_class = flight_class;
    }

    public long getFlightID() {
        return flight_id;
    }

    public void setFlightID(long flight_id) {
        this.flight_id = flight_id;
    }

    public long getUserID() {
        return user_id;
    }

    public void setUserID(long userID) {
        this.user_id = userID;
    }

    public long getPaymentID() {
        return payment_id;
    }

    public void setPaymentID(long payment_id) {
        this.payment_id = payment_id;
    }

    public String getFlightClass() {
        return flight_class;
    }

    public void setFlightClass(String flight_class) {
        this.flight_class = flight_class;
    }
}

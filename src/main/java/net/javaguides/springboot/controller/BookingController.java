package net.javaguides.springboot.controller;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.persistence.Column;
import net.javaguides.springboot.model.Booking;
import net.javaguides.springboot.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.exception.ResourceNotFoundException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")

public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping("/bookings")
    public List<Booking> getAllBookings(){
        return bookingRepository.findAll();
    }

    @PostMapping("/reservation")
    public Booking createBooking(@RequestBody Booking booking){
        return bookingRepository.save(booking);
    }

    @DeleteMapping("/booking/{id}")
    public void deleteBooking(@PathVariable Long id){
        bookingRepository.deleteById(id);
    }

    @PutMapping("/booking/{id}")
    public void updateBooking(@PathVariable Long id, @RequestBody Booking booking){
        Booking oldBooking = bookingRepository.findById(id).get();

        oldBooking.setFlightID(booking.getFlightID());
        oldBooking.setUserID(booking.getUserID());
        oldBooking.setPaymentID(booking.getPaymentID());
        oldBooking.setFlightClass(booking.getFlightClass());

        bookingRepository.save(oldBooking);
    }

    @GetMapping("/bookings/search_by_id/{id}")
    public void searchBookingById(@PathVariable Long id) {

        try {

            Connection connection = DriverManager.getConnection("http://localhost:8080/api/v1");

            Statement statement = connection.createStatement();

            String sql = "SELECT * FROM bookings WHERE user_id = " + id;
            ResultSet resultSet = statement.executeQuery(sql);


            while (resultSet.next()) {

                Long bookingID = resultSet.getLong("bookingID");
                Long flightID = resultSet.getLong("flightID");
                Long userID = resultSet.getLong("userID");
                Long paymentID = resultSet.getLong("paymentID");
                String flightClass = resultSet.getNString("flightClass");


                System.out.println("Booking ID: " + bookingID +
                        "\nFlight ID: " + flightID +
                        "\nUser ID: " + userID +
                        "\nPayment ID: " + paymentID +
                        "\nFlight Class: " + flightClass);
            }

            resultSet.close();
            statement.close();
            connection.close();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

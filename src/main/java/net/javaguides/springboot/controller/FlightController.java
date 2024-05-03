package net.javaguides.springboot.controller;

import java.sql.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.javaguides.springboot.model.Flight;
import net.javaguides.springboot.repository.FlightRepository;
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

public class FlightController {

    @Autowired
    private FlightRepository flightRepository;

    @GetMapping("/flights")
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    @PostMapping("/new_flight")
    public Flight createFlight(@RequestBody Flight flight) {
        return flightRepository.save(flight);
    }

    @DeleteMapping("/flight/{id}")
    public void deleteFlight(@PathVariable Long id) {
        flightRepository.deleteById(id);
    }

    @PutMapping("/flight/{id}")
    public void updateFlight(@PathVariable Long id, @RequestBody Flight flight) {
        Flight oldFlight = flightRepository.findById(id).get();

        oldFlight.setCompanyID(flight.getCompanyID());
        oldFlight.setOriginCityName(flight.getOriginCityName());
        oldFlight.setDestinationCityName(flight.getDestinationCityName());
        oldFlight.setDuration(flight.getDuration());
        oldFlight.setDate(flight.getDate());
        oldFlight.setAvailableEconomSeats(flight.getAvailableEconomSeats());
        oldFlight.setEconomPrice(flight.getEconomPrice());
        oldFlight.setAvailableBusinessSeats(flight.getAvailableBusinessSeats());
        oldFlight.setBusinessPrice(flight.getBusinessPrice());

        flightRepository.save(oldFlight);
    }

    @GetMapping("/flights/search_by_id/{id}")
    public void searchFlightById(@PathVariable Long id) {

        try {

            Connection connection = DriverManager.getConnection("http://localhost:8080/api/v1");

            Statement statement = connection.createStatement();

            String sql = "SELECT * FROM flights WHERE flightID = " + id;
            ResultSet resultSet = statement.executeQuery(sql);


            while (resultSet.next()) {

                Long flightID = resultSet.getLong("flightID");
                Long companyID = resultSet.getLong("companyID");
                String originCityName = resultSet.getNString("originCityName");
                String destinationCityName = resultSet.getNString("destinationCityName");
                int duration = resultSet.getInt("duration");
                String date = resultSet.getNString("date");
                int availableEconomSeats = resultSet.getInt("availableEconomSeats");
                int economPrice = resultSet.getInt("economPrice");
                int availableBusinessSeats = resultSet.getInt("availableBusinessSeats");
                int businessPrice = resultSet.getInt("businessPrice");

                System.out.println("Flight ID: " + flightID +
                        "\nCompany ID: " + companyID +
                        "\nOrigin: " + originCityName +
                        "\nDestination: " + destinationCityName +
                        "\nFlight Duration: " + duration +
                        "\nDeparture Date: " + date +
                        "\nAvailable Econom Seats: " + availableEconomSeats +
                        "\nEconom Price: " + economPrice +
                        "\nAvailable Business Seats: " + availableBusinessSeats +
                        "\nBusiness Price: " + businessPrice);
            }

            resultSet.close();
            statement.close();
            connection.close();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/flights/search_by_city/{city}")
    public void searchFlightByCity(@PathVariable String city){
        try {

            Connection connection = DriverManager.getConnection("http://localhost:8080/api/v1");

            Statement statement = connection.createStatement();

            String sql = "SELECT * FROM flights WHERE originCityName = " + city + "OR destinationCityName = " + city;
            ResultSet resultSet = statement.executeQuery(sql);


            while (resultSet.next()) {

                Long flightId = resultSet.getLong("flightID");
                Long companyID = resultSet.getLong("companyID");
                String originCityName = resultSet.getNString("originCityName");
                String destinationCityName = resultSet.getNString("destinationCityName");
                int duration = resultSet.getInt("duration");
                String date = resultSet.getNString("date");
                int availableEconomSeats = resultSet.getInt("availableEconomSeats");
                int economPrice = resultSet.getInt("economPrice");
                int availableBusinessSeats = resultSet.getInt("availableBusinessSeats");
                int businessPrice = resultSet.getInt("businessPrice");

                System.out.println("Flight ID: " + flightId +
                        "\nCompany ID: " + companyID +
                        "\nOrigin: " + originCityName +
                        "\nDestination: " + destinationCityName +
                        "\nFlight Duration: " + duration +
                        "\nDeparture Date: " + date +
                        "\nAvailable Econom Seats: " + availableEconomSeats +
                        "\nEconom Price: " + economPrice +
                        "\nAvailable Business Seats: " + availableBusinessSeats +
                        "\nBusiness Price: " + businessPrice);
            }

            resultSet.close();
            statement.close();
            connection.close();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
    DATE - format: YYYY-MM-DD.
    DATETIME - format: YYYY-MM-DD HH:MI:SS.
    TIMESTAMP - format: YYYY-MM-DD HH:MI:SS.
    YEAR - format YYYY or YY.
     */

    @GetMapping("/flights/search_by_date/{desiredDate}")
    public void searchFlightByDepartureDate(@PathVariable String desiredDate){
        try {

            Connection connection = DriverManager.getConnection("http://localhost:8080/api/v1");

            Statement statement = connection.createStatement();

            String sql = "SELECT * FROM flights WHERE date = " + desiredDate;
            ResultSet resultSet = statement.executeQuery(sql);


            while (resultSet.next()) {

                Long flightId = resultSet.getLong("flightID");
                Long companyID = resultSet.getLong("companyID");
                String originCityName = resultSet.getNString("originCityName");
                String destinationCityName = resultSet.getNString("destinationCityName");
                int duration = resultSet.getInt("duration");
                String date = resultSet.getNString("date");
                int availableEconomSeats = resultSet.getInt("availableEconomSeats");
                int economPrice = resultSet.getInt("economPrice");
                int availableBusinessSeats = resultSet.getInt("availableBusinessSeats");
                int businessPrice = resultSet.getInt("businessPrice");

                System.out.println("Flight ID: " + flightId +
                        "\nCompany ID: " + companyID +
                        "\nOrigin: " + originCityName +
                        "\nDestination: " + destinationCityName +
                        "\nFlight Duration: " + duration +
                        "\nDeparture Date: " + date +
                        "\nAvailable Econom Seats: " + availableEconomSeats +
                        "\nEconom Price: " + economPrice +
                        "\nAvailable Business Seats: " + availableBusinessSeats +
                        "\nBusiness Price: " + businessPrice);
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



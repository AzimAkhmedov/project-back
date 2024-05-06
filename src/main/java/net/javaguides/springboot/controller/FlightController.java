package net.javaguides.springboot.controller;

import java.sql.*;

import java.util.ArrayList;
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

@CrossOrigin
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
        oldFlight.setOriginID(flight.getOriginID());
        oldFlight.setDestinationID(flight.getDestinationID());
        oldFlight.setDuration(flight.getDuration());
        oldFlight.setDepartureDate(flight.getDepartureDate());
        oldFlight.setAvailableEconomySeats(flight.getAvailableEconomySeats());
        oldFlight.setEconomyPrice(flight.getEconomyPrice());
        oldFlight.setAvailableBusinessSeats(flight.getAvailableBusinessSeats());
        oldFlight.setBusinessPrice(flight.getBusinessPrice());

        flightRepository.save(oldFlight);
    }

    @GetMapping("/flights/search_by_id/{id}")
    public void searchFlightById(@PathVariable Long id) {

        try {

            Connection connection = DriverManager.getConnection("http://localhost:8080/api/v1");

            Statement statement = connection.createStatement();

            String sql = "SELECT * FROM flights WHERE flight_id = " + id;
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                long flight_id = resultSet.getLong("flight_id");
                long company_id = resultSet.getLong("company_id");
                long origin_id = resultSet.getLong("origin_id");
                long destination_id = resultSet.getLong("destination_id");
                int duration = resultSet.getInt("duration");
                String departure_date = resultSet.getNString("departure_date");
                int available_economy_seats = resultSet.getInt("available_economy_seats");
                int economyPrice = resultSet.getInt("economyPrice");
                int available_business_seats = resultSet.getInt("available_business_seats");
                int businessPrice = resultSet.getInt("businessPrice");

                System.out.println("Flight ID: " + flight_id +
                        "\nCompany ID: " + company_id +
                        "\nOrigin ID: " + origin_id +
                        "\nDestination ID: " + destination_id +
                        "\nFlight Duration: " + duration +
                        "\nDeparture Date: " + departure_date +
                        "\nAvailable Economy Seats: " + available_economy_seats +
                        "\nEconomy Price: " + economyPrice +
                        "\nAvailable Business Seats: " + available_business_seats +
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

    @GetMapping("/flights/search_by_company_id/{company_id}")
    public List<Flight> searchFlightByCompanyId(@PathVariable Integer company_id){
        return  flightRepository.findFlightByCompany_id(company_id);
    }

    @GetMapping("/flights/search_by_city/{city}")
    public void searchFlightByCity(@PathVariable String city){
        try {

            Connection connection = DriverManager.getConnection("http://localhost:8080/api/v1");

            Statement statement = connection.createStatement();

            String sql = "SELECT flights.*\n" +
                    "FROM flights INNER JOIN cities\n" +
                    "ON flights.origin_id = cities.city_id OR flights.destination_id = cities.city_id\n" +
                    "WHERE city_name = '" + city + "'";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                long flight_id = resultSet.getLong("flight_id");
                long company_id = resultSet.getLong("company_id");
                long origin_id = resultSet.getLong("origin_id");
                long destination_id = resultSet.getLong("destination_id");
                int duration = resultSet.getInt("duration");
                String departure_date = resultSet.getNString("departure_date");
                int available_economy_seats = resultSet.getInt("available_economy_seats");
                int economyPrice = resultSet.getInt("economyPrice");
                int available_business_seats = resultSet.getInt("available_business_seats");
                int businessPrice = resultSet.getInt("businessPrice");

                System.out.println("Flight ID: " + flight_id +
                        "\nCompany ID: " + company_id +
                        "\nOrigin ID: " + origin_id +
                        "\nDestination ID: " + destination_id +
                        "\nFlight Duration: " + duration +
                        "\nDeparture Date: " + departure_date +
                        "\nAvailable Economy Seats: " + available_economy_seats +
                        "\nEconomy Price: " + economyPrice +
                        "\nAvailable Business Seats: " + available_business_seats +
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

    public List<Flight> searchFlightByDepartureDate(@PathVariable String desiredDate) throws SQLException{
     return flightRepository.findFlightByDeparture_date(desiredDate);
    }
}



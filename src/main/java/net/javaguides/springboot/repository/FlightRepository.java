package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.Flight;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long>{
    @Query("SELECT u FROM Flight u WHERE u.departure_date = :departure_date")
    List<Flight> findFlightByDeparture_date(@Param("departure_date") String departure_date);

    @Query("select  f from Flight  f where f.company_id =:company_id")
    List<Flight> findFlightByCompany_id(@Param("company_id") Integer company_id);
}

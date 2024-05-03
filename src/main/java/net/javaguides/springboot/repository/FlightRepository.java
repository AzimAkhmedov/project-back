package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.Flight;
public interface FlightRepository extends JpaRepository<Flight, Long>{
}

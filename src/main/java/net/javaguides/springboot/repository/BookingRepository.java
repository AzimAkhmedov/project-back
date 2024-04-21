package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long>{
}

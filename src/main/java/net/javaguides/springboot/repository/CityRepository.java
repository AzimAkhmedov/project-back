package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.City;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long>{
}

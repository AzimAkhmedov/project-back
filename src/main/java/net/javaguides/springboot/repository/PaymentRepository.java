package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{
}

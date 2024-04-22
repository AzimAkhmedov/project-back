package net.javaguides.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.javaguides.springboot.model.Payment;
import net.javaguides.springboot.repository.PaymentRepository;
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

public class PaymentController {
    @Autowired
    private PaymentRepository paymentRepository;

    @GetMapping("/payments")
    public List<Payment> getAllPayments(){
        return paymentRepository.findAll();
    }

    @PostMapping("/pay")
    public Payment createPayment(@RequestBody Payment payment){
        return paymentRepository.save(payment);
    }

    @DeleteMapping("/payment/{id}")
    public void deletePayment(@PathVariable Long id){
        paymentRepository.deleteById(id);
    }

    @PutMapping("/payment/{id}")
    public void updatePayment(@PathVariable Long id, @RequestBody Payment payment){
        Payment oldPayment = paymentRepository.findById(id).get();

        oldPayment.setRecipientID(payment.getRecipientID());
        oldPayment.setSenderID(payment.getSenderID());
        oldPayment.setDate(payment.getDate());
        oldPayment.setPaymentStatus(payment.getPaymentStatus());
        oldPayment.setAmount(payment.getAmount());

        paymentRepository.save(oldPayment);
    }
}

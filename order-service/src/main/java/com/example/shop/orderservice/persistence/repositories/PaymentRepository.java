package com.example.shop.orderservice.persistence.repositories;

import com.example.shop.orderservice.persistence.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {}

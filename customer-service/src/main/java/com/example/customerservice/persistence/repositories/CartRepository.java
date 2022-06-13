package com.example.customerservice.persistence.repositories;

import com.example.customerservice.persistence.enums.CartStatus;
import com.example.customerservice.persistence.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
  List<Cart> findAll();

  Optional<Cart> findById(Long id);

  List<Cart> findByStatus(CartStatus status);

  List<Cart> findByStatusAndCustomerId(CartStatus status, Long customerId);

  Optional<Cart> findByCustomerId(Long id);
}

package com.example.shop.persistence.repositories;

import com.example.shop.persistence.enums.CartStatus;
import com.example.shop.persistence.model.Cart;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
  List<Cart> findAll();

  Optional<Cart> findById(Long id);

  List<Cart> findByStatus(CartStatus status);

  List<Cart> findByStatusAndCustomerId(CartStatus status, Long customerId);
}

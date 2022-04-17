package com.example.shop.persistence.repositories;

import com.example.shop.persistence.model.Order;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
  List<Order> findAllByCartCustomerId(Long id);
}

package com.example.shop.orderservice.persistence.repositories;

import com.example.shop.orderservice.persistence.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {}

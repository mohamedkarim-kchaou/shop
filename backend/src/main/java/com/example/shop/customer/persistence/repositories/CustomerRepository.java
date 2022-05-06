package com.example.shop.customer.persistence.repositories;

import com.example.shop.customer.persistence.model.Customer;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
  Optional<Customer> findById(Long id);

  List<Customer> findAll();

  List<Customer> findAllByEnabled(boolean enabled);
}

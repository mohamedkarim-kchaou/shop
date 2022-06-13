package com.example.customerservice.persistence.repositories;

import com.example.customerservice.persistence.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
  Optional<Customer> findById(Long id);

  List<Customer> findAll();

  List<Customer> findAllByEnabled(boolean enabled);
}

package com.example.customerservice.services.customerService;

import com.example.customerservice.persistence.dto.CustomerDto;
import com.example.customerservice.persistence.model.Customer;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
  CustomerDto mapToDto(Customer customer);

  Optional<Customer> findById(Long id);

  CustomerDto create(CustomerDto customerDto);

  List<CustomerDto> findAll();

  @Transactional
  CustomerDto findByIdDto(Long id);

  List<CustomerDto> findAllActive();

  List<CustomerDto> findAllInactive();

  void delete(Long id);
}

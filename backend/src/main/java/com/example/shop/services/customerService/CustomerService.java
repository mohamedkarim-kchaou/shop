package com.example.shop.services.customerService;

import com.example.shop.persistence.dto.CustomerDto;
import com.example.shop.persistence.model.Customer;
import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;

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

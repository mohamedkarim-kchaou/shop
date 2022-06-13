package com.example.customerservice.services.customerService.impl;

import com.example.customerservice.exceptions.CustomerNotFoundException;
import com.example.customerservice.persistence.dto.CustomerDto;
import com.example.customerservice.persistence.model.Customer;
import com.example.customerservice.persistence.repositories.CustomerRepository;
import com.example.customerservice.services.customerService.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Transactional
@Service
public class CustomerServiceImpl implements CustomerService {

  private final CustomerRepository customerRepository;

  @Override
  public CustomerDto mapToDto(Customer customer) {
    if (Objects.nonNull(customer)) {
      return new CustomerDto(
          customer.getId(),
          customer.getFirstName(),
          customer.getLastName(),
          customer.getEmail(),
          customer.getTelephone(),
          customer.getEnabled());
    }
    return null;
  }

  @Override
  public Optional<Customer> findById(Long id) {
    return customerRepository.findById(id);
  }

  @Override
  public CustomerDto create(CustomerDto customerDto) {
    return mapToDto(
        customerRepository.save(
            Customer.builder()
                .firstName(customerDto.getFirstName())
                .lastName(customerDto.getLastName())
                .telephone(customerDto.getTelephone())
                .email(customerDto.getEmail())
                .enabled(customerDto.getEnabled())
                .build()));
  }

  @Override
  public List<CustomerDto> findAll() {
    return customerRepository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
  }

  @Transactional
  @Override
  public CustomerDto findByIdDto(Long id) {
    log.debug("Request to get Customer : {}", id);
    return mapToDto(customerRepository.findById(id).orElseThrow(CustomerNotFoundException::new));
  }

  @Override
  public List<CustomerDto> findAllActive() {
    log.debug("Request to get all active Customers");
    return customerRepository.findAllByEnabled(true).stream()
        .map(this::mapToDto)
        .collect(Collectors.toList());
  }

  @Override
  public List<CustomerDto> findAllInactive() {
    log.debug("Request to get all inactive Customers");
    return customerRepository.findAllByEnabled(false).stream()
        .map(this::mapToDto)
        .collect(Collectors.toList());
  }

  @Override
  public void delete(Long id) {
    log.debug("Request to delete Customer : {}", id);
    Customer customer = customerRepository.findById(id).orElseThrow(CustomerNotFoundException::new);
    customer.setEnabled(false);
    customerRepository.save(customer);
  }
}

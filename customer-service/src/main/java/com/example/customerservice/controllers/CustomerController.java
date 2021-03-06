package com.example.customerservice.controllers;

import com.example.customerservice.persistence.dto.CustomerDto;
import com.example.customerservice.services.customerService.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/customers")
public class CustomerController {
  private final CustomerService customerService;

  @GetMapping
  public List<CustomerDto> findAll() {
    return customerService.findAll();
  }

  @GetMapping("/{id}")
  public CustomerDto findById(@PathVariable Long id) {
    return customerService.findByIdDto(id);
  }

  @GetMapping("/active")
  public List<CustomerDto> findAllActive() {
    return customerService.findAllActive();
  }

  @GetMapping("/inactive")
  public List<CustomerDto> findAllInactive() {
    return customerService.findAllInactive();
  }

  @PostMapping
  public CustomerDto create(CustomerDto customerDto) {
    return customerService.create(customerDto);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    customerService.delete(id);
  }
}

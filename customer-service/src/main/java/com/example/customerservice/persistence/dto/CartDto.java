package com.example.customerservice.persistence.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CartDto {
  private Long id;
  private Long orderId;
  private CustomerDto customer;
  private String status;
}

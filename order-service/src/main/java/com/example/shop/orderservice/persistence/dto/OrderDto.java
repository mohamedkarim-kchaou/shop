package com.example.shop.orderservice.persistence.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@Builder
public class OrderDto {
  private Long id;
  private BigDecimal totalPrice;
  private String status;
  private ZonedDateTime shipped;
  private PaymentDto payment;
  private AddressDto shipmentAddress;
  private Set<OrderItemDto> orderItems;
}

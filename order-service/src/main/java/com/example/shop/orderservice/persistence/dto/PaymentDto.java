package com.example.shop.orderservice.persistence.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class PaymentDto {
  private String paypalPaymentId;
  private String status;
  private Long orderId;
}

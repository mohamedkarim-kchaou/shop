package com.example.shop.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class OrderItemDto {
  private Long id;
  private Long quantity;
  private Long productId;
  private Long orderId;
}

package com.example.shop.productservice.persistence.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
@AllArgsConstructor
@Builder
public class ProductDto {
  private Long id;
  private String name;
  private String description;
  private BigDecimal price;
  private Integer quantity;
  private String status;
  private Integer salesCounter;
  private Set<ReviewDto> reviews;
  private Long categoryId;
}

package com.example.shop.commons.dto;

import java.math.BigDecimal;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

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

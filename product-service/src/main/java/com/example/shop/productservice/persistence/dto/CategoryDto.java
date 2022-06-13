package com.example.shop.productservice.persistence.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
@Builder
public class CategoryDto {
  private Long id;
  private String name;
  private String description;
  private Set<ProductDto> products;
}

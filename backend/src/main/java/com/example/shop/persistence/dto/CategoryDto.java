package com.example.shop.persistence.dto;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CategoryDto {
  private Long id;
  private String name;
  private String description;
  private Set<ProductDto> products;
}

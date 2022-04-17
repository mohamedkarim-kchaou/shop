package com.example.shop.persistence.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ReviewDto {
  private Long id;
  private String title;
  private String description;
  private Long rating;
}

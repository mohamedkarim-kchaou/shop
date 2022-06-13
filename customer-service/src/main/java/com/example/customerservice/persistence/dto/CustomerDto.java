package com.example.customerservice.persistence.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CustomerDto {
  private Long id;
  private String firstName;
  private String lastName;
  private String email;
  private String telephone;
  private Boolean enabled;
}

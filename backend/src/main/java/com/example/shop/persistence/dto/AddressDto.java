package com.example.shop.persistence.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class AddressDto {
  private Long id;
  private String address1;
  private String address2;
  private String city;
  private String postCode;
  private String country;
}

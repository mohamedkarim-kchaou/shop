package com.example.shop.persistence.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Embeddable
public class Address {
  private String address1;
  private String address2;
  private String city;

  @NotNull
  @Column(length = 10)
  private String postCode;

  @NotNull
  @Column(length = 2)
  private String country;
}

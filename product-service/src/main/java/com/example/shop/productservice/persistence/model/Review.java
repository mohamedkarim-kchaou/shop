package com.example.shop.productservice.persistence.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
public class Review extends AbstractEntity {
  @NotNull private String title;
  @NotNull private String description;
  @NotNull private Long rating;
}

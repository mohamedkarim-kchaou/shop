package com.example.shop.persistence.model;

import com.example.shop.persistence.enums.ProductStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Builder
@Entity
public class Product extends AbstractEntity {
  @NotNull private String name;
  @NotNull private String description;

  @NotNull
  @Column(precision = 10, scale = 2)
  private BigDecimal price;

  private Integer quantity;

  @NotNull
  @Enumerated(EnumType.STRING)
  private ProductStatus status;

  private Integer salesCounter;
  @OneToMany @JsonIgnore private Set<Review> reviews = new HashSet<>();
  @ManyToOne private Category category;
}

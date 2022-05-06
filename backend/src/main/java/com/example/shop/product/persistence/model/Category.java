package com.example.shop.product.persistence.model;

import com.example.shop.commons.model.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Builder
@Entity
public class Category extends AbstractEntity {
  @NotNull private String name;
  @NotNull private String description;

  @OneToMany(mappedBy = "category")
  @Builder.Default
  @JsonIgnore
  private Set<Product> products = new HashSet<>();
}

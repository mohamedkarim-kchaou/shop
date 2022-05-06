package com.example.shop.customer.persistence.model;

import com.example.shop.commons.model.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Builder
@Entity
public class Customer extends AbstractEntity {
  private String firstName;
  private String lastName;
  private String email;
  private String telephone;
  private Boolean enabled;

  @OneToMany(mappedBy = "customer")
  @JsonIgnore
  private Set<Cart> carts;
}

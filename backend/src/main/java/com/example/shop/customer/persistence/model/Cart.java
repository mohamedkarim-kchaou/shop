package com.example.shop.customer.persistence.model;

import com.example.shop.commons.model.AbstractEntity;
import com.example.shop.customer.persistence.enums.CartStatus;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Builder
@Entity
public class Cart extends AbstractEntity {
  private static final long serialVersionUID = 1L;
  @ManyToOne private Customer customer;

  private Long orderId;

  @NotNull
  @Enumerated(EnumType.STRING)
  private CartStatus status;
}

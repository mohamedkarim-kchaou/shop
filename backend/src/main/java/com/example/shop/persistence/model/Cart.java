package com.example.shop.persistence.model;

import com.example.shop.persistence.enums.CartStatus;
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

  @OneToOne private Order order;

  @NotNull
  @Enumerated(EnumType.STRING)
  private CartStatus status;
}

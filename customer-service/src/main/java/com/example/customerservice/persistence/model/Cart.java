package com.example.customerservice.persistence.model;

import com.example.customerservice.persistence.enums.CartStatus;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

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

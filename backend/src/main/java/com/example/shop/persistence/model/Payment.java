package com.example.shop.persistence.model;

import com.example.shop.persistence.enums.PaymentStatus;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Builder
@Entity
public class Payment extends AbstractEntity {
  private String paypalPaymentId;

  @NotNull
  @Enumerated(EnumType.STRING)
  private PaymentStatus status;

  @OneToOne private Order order;
}

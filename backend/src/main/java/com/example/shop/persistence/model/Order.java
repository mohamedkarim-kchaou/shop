package com.example.shop.persistence.model;

import com.example.shop.persistence.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
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
public class Order extends AbstractEntity {
  @NotNull
  @Column(name = "total_price", precision = 10, scale = 2)
  private BigDecimal totalPrice;

  @NotNull
  @Enumerated(EnumType.STRING)
  private OrderStatus status;

  private ZonedDateTime shipped;

  @OneToOne
  @JoinColumn(unique = true)
  private Payment payment;

  @Embedded private Address shipmentAddress;

  @OneToMany(mappedBy = "order")
  @JsonIgnore
  private Set<OrderItem> orderItems;

  @OneToOne(mappedBy = "order")
  @JsonIgnore
  private Cart cart;
}

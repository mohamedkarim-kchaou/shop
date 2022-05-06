package com.example.shop.order.persistence.model;

import com.example.shop.commons.model.AbstractEntity;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
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
public class OrderItem extends AbstractEntity {
  @NotNull private Long quantity;
  private Long productId;
  @ManyToOne private Order order;
}

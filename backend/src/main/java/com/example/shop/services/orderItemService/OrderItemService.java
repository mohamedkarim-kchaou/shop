package com.example.shop.services.orderItemService;

import com.example.shop.persistence.dto.OrderItemDto;
import com.example.shop.persistence.model.OrderItem;
import java.util.List;

public interface OrderItemService {
  List<OrderItemDto> findAll();

  OrderItemDto findById(Long id);

  OrderItemDto create(OrderItemDto orderItemDto);

  void delete(Long id);

  OrderItemDto mapToDto(OrderItem orderItem);
}

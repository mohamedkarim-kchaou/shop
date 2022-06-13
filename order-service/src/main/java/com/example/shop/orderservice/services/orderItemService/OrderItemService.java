package com.example.shop.orderservice.services.orderItemService;

import com.example.shop.orderservice.persistence.dto.OrderItemDto;
import com.example.shop.orderservice.persistence.model.OrderItem;
import java.util.List;

public interface OrderItemService {
  List<OrderItemDto> findAll();

  OrderItemDto findById(Long id);

  OrderItemDto create(OrderItemDto orderItemDto);

  void delete(Long id);

  OrderItemDto mapToDto(OrderItem orderItem);
}

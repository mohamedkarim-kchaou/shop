package com.example.shop.orderservice.services.orderService;

import com.example.shop.orderservice.persistence.dto.OrderDto;
import com.example.shop.orderservice.persistence.model.Order;
import java.util.List;
import java.util.Optional;

public interface OrderService {

  Optional<Order> findById(Long id);

  List<OrderDto> findAll();

  OrderDto findByIdDto(Long id);

  List<OrderDto> findAllByUserId(Long id);

  OrderDto create(OrderDto orderDto);

  void delete(Long id);

  OrderDto mapToDto(Order order);
}

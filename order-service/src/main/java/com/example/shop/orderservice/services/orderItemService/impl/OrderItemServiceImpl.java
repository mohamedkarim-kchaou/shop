package com.example.shop.orderservice.services.orderItemService.impl;

import com.example.shop.orderservice.exceptions.OrderNotFoundException;
import com.example.shop.orderservice.persistence.dto.OrderItemDto;
import com.example.shop.orderservice.persistence.model.Order;
import com.example.shop.orderservice.persistence.model.OrderItem;
import com.example.shop.orderservice.persistence.repositories.OrderItemRepository;
import com.example.shop.orderservice.services.orderItemService.OrderItemService;
import com.example.shop.orderservice.services.orderService.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Slf4j
@Service
public class OrderItemServiceImpl implements OrderItemService {

  private final OrderItemRepository orderItemRepository;
  private OrderService orderService;

  @Autowired
  public void setOrderService(OrderService orderService) {
    this.orderService = orderService;
  }

  @Override
  public List<OrderItemDto> findAll() {
    log.debug("Request to get all OrderItems");
    return orderItemRepository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
  }

  @Transactional(readOnly = true)
  @Override
  public OrderItemDto findById(Long id) {
    log.debug("Request to get OrderItem : {}", id);
    return mapToDto(orderItemRepository.findById(id).orElse(null));
  }

  @Override
  public OrderItemDto create(OrderItemDto orderItemDto) {
    log.debug("Request to create OrderItem : {}", orderItemDto);
    Order order =
        orderService.findById(orderItemDto.getOrderId()).orElseThrow(OrderNotFoundException::new);
    return mapToDto(
        orderItemRepository.save(
            new OrderItem(orderItemDto.getQuantity(), orderItemDto.getProductId(), order)));
  }

  @Override
  public void delete(Long id) {
    log.debug("Request to delete OrderItem : {}", id);
    orderItemRepository.deleteById(id);
  }

  @Override
  public OrderItemDto mapToDto(OrderItem orderItem) {
    if (Objects.nonNull(orderItem)) {
      return OrderItemDto.builder()
          .id(orderItem.getId())
          .orderId(orderItem.getOrder().getId())
          .productId(orderItem.getProductId())
          .quantity(orderItem.getQuantity())
          .build();
    } else {
      return null;
    }
  }
}

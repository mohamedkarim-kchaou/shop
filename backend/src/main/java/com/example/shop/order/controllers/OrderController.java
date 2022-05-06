package com.example.shop.order.controllers;

import com.example.shop.commons.dto.OrderDto;
import com.example.shop.order.services.orderService.OrderService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/orders")
public class OrderController {
  private final OrderService orderService;

  @GetMapping
  public List<OrderDto> findAll() {
    return orderService.findAll();
  }

  @GetMapping("/customer/{id}")
  public List<OrderDto> findAllByUser(@PathVariable Long id) {
    return orderService.findAllByUserId(id);
  }

  @GetMapping("/{id}")
  public OrderDto findById(@PathVariable Long id) {
    return orderService.findByIdDto(id);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    orderService.delete(id);
  }
}

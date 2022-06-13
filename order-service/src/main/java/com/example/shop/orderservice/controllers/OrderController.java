package com.example.shop.orderservice.controllers;

import com.example.shop.orderservice.persistence.dto.OrderDto;
import com.example.shop.orderservice.services.orderService.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

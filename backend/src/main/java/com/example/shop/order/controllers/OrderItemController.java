package com.example.shop.order.controllers;

import com.example.shop.commons.dto.OrderItemDto;
import com.example.shop.order.services.orderItemService.OrderItemService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/order-items")
public class OrderItemController {
  private final OrderItemService itemService;

  @GetMapping
  public List<OrderItemDto> findAll() {
    return itemService.findAll();
  }

  @GetMapping("/{id}")
  public OrderItemDto findById(@PathVariable Long id) {
    return itemService.findById(id);
  }

  @PostMapping
  public OrderItemDto create(@RequestBody OrderItemDto orderItemDto) {
    return itemService.create(orderItemDto);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    itemService.delete(id);
  }
}

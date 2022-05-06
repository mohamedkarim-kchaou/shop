package com.example.shop.order.controllers;

import com.example.shop.commons.dto.PaymentDto;
import com.example.shop.order.services.paymentService.PaymentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/payments")
public class PaymentController {
  private final PaymentService paymentService;

  @GetMapping
  public List<PaymentDto> findAll() {
    return paymentService.findAll();
  }

  @GetMapping("/{id}")
  public PaymentDto findById(@PathVariable Long id) {
    return paymentService.findById(id);
  }

  @PostMapping
  public PaymentDto create(@RequestBody PaymentDto orderItemDto) {
    return paymentService.create(orderItemDto);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    paymentService.delete(id);
  }
}

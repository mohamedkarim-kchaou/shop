package com.example.customerservice.controllers;

import com.example.customerservice.persistence.dto.CartDto;
import com.example.customerservice.services.cartService.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/carts")
public class CartController {
  private final CartService cartService;

  @GetMapping
  public List<CartDto> findAll() {
    return cartService.findAll();
  }

  @GetMapping("/active")
  public List<CartDto> findAllActiveCarts() {
    return cartService.findAllActiveCarts();
  }

  @GetMapping("/customer/{id}")
  public CartDto getActiveCartForCustomer(@PathVariable("id") Long customerId) {
    return cartService.getActiveCart(customerId);
  }

  @GetMapping("/{id}")
  public CartDto findById(@PathVariable Long id) {
    return cartService.findById(id);
  }

  @PostMapping("/customer/{id}")
  public CartDto create(@PathVariable("id") Long customerId) {
    return cartService.create(customerId);
  }

  @DeleteMapping("/{id}")
  public CartDto delete(@PathVariable Long id) {
    return cartService.delete(id);
  }
}

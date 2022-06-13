package com.example.customerservice.services.cartService;

import com.example.customerservice.persistence.dto.CartDto;
import com.example.customerservice.persistence.model.Cart;

import java.util.List;

public interface CartService {
  List<CartDto> findAll();

  List<CartDto> findAllActiveCarts();

  CartDto mapToDto(Cart cart);

  CartDto create(Long customerId);

    Long getCartIdByCustomerId(Long id);

    CartDto getActiveCart(Long customerId);

  CartDto findById(Long id);

  CartDto delete(Long id);
}

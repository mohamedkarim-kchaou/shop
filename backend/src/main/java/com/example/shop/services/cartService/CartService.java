package com.example.shop.services.cartService;

import com.example.shop.persistence.dto.CartDto;
import com.example.shop.persistence.model.Cart;
import java.util.List;

public interface CartService {
  List<CartDto> findAll();

  List<CartDto> findAllActiveCarts();

  CartDto mapToDto(Cart cart);

  CartDto create(Long customerId);

  CartDto getActiveCart(Long customerId);

  CartDto findById(Long id);

  void delete(Long id);
}

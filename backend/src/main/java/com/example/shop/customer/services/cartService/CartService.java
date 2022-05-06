package com.example.shop.customer.services.cartService;

import com.example.shop.commons.dto.CartDto;
import com.example.shop.customer.persistence.model.Cart;
import java.util.List;

public interface CartService {
  List<CartDto> findAll();

  List<CartDto> findAllActiveCarts();

  CartDto mapToDto(Cart cart);

  CartDto create(Long customerId);

    Long getCartIdByCustomerId(Long id);

    CartDto getActiveCart(Long customerId);

  CartDto findById(Long id);

  void delete(Long id);
}

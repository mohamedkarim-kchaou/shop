package com.example.shop.customer.exceptions;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@NoArgsConstructor
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Cart not found")
public class CartNotFoundException extends RuntimeException {
  CartNotFoundException(String message) {
    super(message);
  }
}

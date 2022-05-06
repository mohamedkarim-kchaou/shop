package com.example.shop.customer.exceptions;

public class ManyActiveCartsException extends IllegalStateException {

  public ManyActiveCartsException() {
    super("Many active carts detected");
  }
}

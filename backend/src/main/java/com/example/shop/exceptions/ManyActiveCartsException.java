package com.example.shop.exceptions;

public class ManyActiveCartsException extends IllegalStateException {

  public ManyActiveCartsException() {
    super("Many active carts detected");
  }
}

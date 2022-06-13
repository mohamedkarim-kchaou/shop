package com.example.customerservice.exceptions;

public class ManyActiveCartsException extends IllegalStateException {

  public ManyActiveCartsException() {
    super("Many active carts detected");
  }
}

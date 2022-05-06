package com.example.shop.customer.exceptions;

public class AlreadyActiveCartException extends IllegalStateException {

  public AlreadyActiveCartException() {
    super("Already active cart detected");
  }
}

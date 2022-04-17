package com.example.shop.exceptions;

public class AlreadyActiveCartException extends IllegalStateException {

  public AlreadyActiveCartException() {
    super("Already active cart detected");
  }
}

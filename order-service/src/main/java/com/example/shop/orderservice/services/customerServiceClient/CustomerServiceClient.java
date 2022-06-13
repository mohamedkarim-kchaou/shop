package com.example.shop.orderservice.services.customerServiceClient;

import com.example.shop.orderservice.persistence.dto.CartDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@FeignClient(name = "customer-service", fallback = HystrixClientFallback.class)
public interface CustomerServiceClient {
  @RequestMapping(value = "/v1/carts/customer/{id}", method = GET)
  public CartDto getActiveCartForCustomer(@PathVariable("id") Long id);
}

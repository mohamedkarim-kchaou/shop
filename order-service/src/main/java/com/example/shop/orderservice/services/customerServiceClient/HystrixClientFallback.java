package com.example.shop.orderservice.services.customerServiceClient;

import com.example.shop.orderservice.persistence.dto.CartDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HystrixClientFallback implements CustomerServiceClient {
    @Override
    public CartDto getActiveCartForCustomer(Long id) {
        log.info("Returning default active cart for Id: " + id);
        return CartDto.builder().id(id).status("None").build();
    }
}

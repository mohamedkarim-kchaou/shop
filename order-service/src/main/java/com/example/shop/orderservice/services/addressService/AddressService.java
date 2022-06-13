package com.example.shop.orderservice.services.addressService;

import com.example.shop.orderservice.persistence.dto.AddressDto;
import com.example.shop.orderservice.persistence.model.Address;

public interface AddressService {
  AddressDto mapToDto(Address address);
}

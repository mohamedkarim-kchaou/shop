package com.example.shop.services.addressService;

import com.example.shop.persistence.dto.AddressDto;
import com.example.shop.persistence.model.Address;

public interface AddressService {
  AddressDto mapToDto(Address address);
}

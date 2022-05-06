package com.example.shop.commons.services.addressService;

import com.example.shop.commons.dto.AddressDto;
import com.example.shop.commons.model.Address;

public interface AddressService {
  AddressDto mapToDto(Address address);
}

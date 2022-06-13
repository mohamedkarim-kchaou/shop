package com.example.shop.orderservice.services.addressService.impl;

import com.example.shop.orderservice.persistence.dto.AddressDto;
import com.example.shop.orderservice.persistence.model.Address;
import com.example.shop.orderservice.services.addressService.AddressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@RequiredArgsConstructor
@Slf4j
@Transactional
@Service
public class AddressServiceImpl implements AddressService {
  @Override
  public AddressDto mapToDto(Address address) {
    if (Objects.nonNull(address)) {
      return AddressDto.builder()
          .address1(address.getAddress1())
          .address2(address.getAddress2())
          .city(address.getCity())
          .country(address.getCountry())
          .postCode(address.getPostCode())
          .build();
    } else return null;
  }
}

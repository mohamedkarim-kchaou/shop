package com.example.shop.commons.services.addressService.impl;

import java.util.Objects;

import com.example.shop.commons.services.addressService.AddressService;
import com.example.shop.commons.model.Address;
import com.example.shop.commons.dto.AddressDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

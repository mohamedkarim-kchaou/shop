package com.example.customerservice.services.cartService.impl;

import com.example.customerservice.exceptions.AlreadyActiveCartException;
import com.example.customerservice.exceptions.CartNotFoundException;
import com.example.customerservice.exceptions.CustomerNotFoundException;
import com.example.customerservice.exceptions.ManyActiveCartsException;
import com.example.customerservice.persistence.dto.CartDto;
import com.example.customerservice.persistence.enums.CartStatus;
import com.example.customerservice.persistence.model.Cart;
import com.example.customerservice.persistence.model.Customer;
import com.example.customerservice.persistence.repositories.CartRepository;
import com.example.customerservice.services.cartService.CartService;
import com.example.customerservice.services.customerService.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Transactional
@Service
public class CartServiceImpl implements CartService {

  private final CartRepository cartRepository;
  private final CustomerService customerService;

  @Override
  public List<CartDto> findAll() {
    log.debug("Request to get all Carts");
    return cartRepository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
  }

  @Override
  public List<CartDto> findAllActiveCarts() {
    log.debug("Request to get all Carts");
    return cartRepository.findByStatus(CartStatus.NEW).stream()
        .map(this::mapToDto)
        .collect(Collectors.toList());
  }

  @Override
  public CartDto mapToDto(Cart cart) {
    if (Objects.nonNull(cart)) {
      return new CartDto(
          cart.getId(),
          cart.getOrderId(),
          customerService.mapToDto(cart.getCustomer()),
          cart.getStatus().name());
    }
    return null;
  }

  @Override
  public CartDto create(Long customerId) {
    Customer customer =
        customerService.findById(customerId).orElseThrow(CustomerNotFoundException::new);
    if (Objects.isNull(getActiveCart(customerId))) {
      return mapToDto(
          cartRepository.save(Cart.builder().customer(customer).status(CartStatus.NEW).build()));
    } else {
      throw new AlreadyActiveCartException();
    }
  }

  @Override
  public Long getCartIdByCustomerId(Long id){
    return cartRepository.findByCustomerId(id).orElseThrow(CustomerNotFoundException::new).getId();
  }
  @Override
  public CartDto getActiveCart(Long customerId) {
    List<Cart> activeCarts = cartRepository.findByStatusAndCustomerId(CartStatus.NEW, customerId);
    if (Objects.nonNull(activeCarts)) {
      if (activeCarts.size() == 1) {
        return mapToDto(activeCarts.get(0));
      } else {
        throw new ManyActiveCartsException();
      }
    }
    return null;
  }

  @Transactional(readOnly = true)
  @Override
  public CartDto findById(Long id) {
    log.debug("Request to get Cart : {}", id);
    return mapToDto(cartRepository.findById(id).orElse(null));
  }

  @Override
  public CartDto delete(Long id) {
    log.debug("Request to delete Cart : {}", id);
    Cart cart = cartRepository.findById(id).orElseThrow(CartNotFoundException::new);
    cart.setStatus(CartStatus.CANCELED);
    return this.mapToDto(cartRepository.save(cart));
  }
}

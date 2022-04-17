package com.example.shop.services.orderService.orderServiceImpl;

import com.example.shop.persistence.dto.OrderDto;
import com.example.shop.persistence.enums.OrderStatus;
import com.example.shop.persistence.model.Order;
import com.example.shop.persistence.repositories.OrderRepository;
import com.example.shop.services.addressService.AddressService;
import com.example.shop.services.orderItemService.OrderItemService;
import com.example.shop.services.orderService.OrderService;
import com.example.shop.services.paymentService.PaymentService;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Slf4j
@Transactional
@Service
public class OrderServImpl implements OrderService {

  private final OrderRepository orderRepository;
  private OrderItemService orderItemService;
  private PaymentService paymentService;
  private final AddressService addressService;

  @Autowired
  public void setOrderItemService(OrderItemService orderItemService) {
    this.orderItemService = orderItemService;
  }

  @Autowired
  public void setPaymentService(PaymentService paymentService) {
    this.paymentService = paymentService;
  }

  @Override
  public Optional<Order> findById(Long id) {
    return orderRepository.findById(id);
  }

  @Override
  public List<OrderDto> findAll() {
    return orderRepository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
  }

  @Transactional(readOnly = true)
  @Override
  public OrderDto findByIdDto(Long id) {
    log.debug("Request to get Order : {}", id);
    return mapToDto(orderRepository.findById(id).orElse(null));
  }

  @Override
  public List<OrderDto> findAllByUser(Long id) {
    return orderRepository.findAllByCartCustomerId(id).stream()
        .map(this::mapToDto)
        .collect(Collectors.toList());
  }

  @Override
  public OrderDto create(OrderDto orderDto) {
    log.debug("Request to create Order : {}", orderDto);
    return mapToDto(
        orderRepository.save(
            Order.builder()
                .totalPrice(BigDecimal.ZERO)
                .status(OrderStatus.CREATION)
                .orderItems(Collections.emptySet())
                .build()));
  }

  @Override
  public void delete(Long id) {
    log.debug("Request to delete Order : {}", id);
    this.orderRepository.deleteById(id);
  }

  @Override
  public OrderDto mapToDto(Order order) {
    if (Objects.nonNull(order)) {
      return OrderDto.builder()
          .status(order.getStatus().name())
          .orderItems(
              order.getOrderItems().stream()
                  .map(orderItemService::mapToDto)
                  .collect(Collectors.toSet()))
          .id(order.getId())
          .payment(paymentService.mapToDto(order.getPayment()))
          .totalPrice(order.getTotalPrice())
          .shipmentAddress(addressService.mapToDto(order.getShipmentAddress()))
          .build();
    } else {
      return null;
    }
  }
}

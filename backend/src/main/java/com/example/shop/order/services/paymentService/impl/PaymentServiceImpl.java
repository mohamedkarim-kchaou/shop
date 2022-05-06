package com.example.shop.order.services.paymentService.impl;

import com.example.shop.commons.dto.PaymentDto;
import com.example.shop.order.exceptions.OrderNotFoundException;
import com.example.shop.order.persistence.enums.PaymentStatus;
import com.example.shop.order.persistence.model.Order;
import com.example.shop.order.persistence.model.Payment;
import com.example.shop.order.persistence.repositories.PaymentRepository;
import com.example.shop.order.services.orderService.OrderService;
import com.example.shop.order.services.paymentService.PaymentService;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Slf4j
@Service
public class PaymentServiceImpl implements PaymentService {

  private final PaymentRepository paymentRepository;
  private OrderService orderService;

  @Autowired
  public void setOrderService(OrderService orderService) {
    this.orderService = orderService;
  }

  @Override
  public List<PaymentDto> findAll() {
    log.debug("Request to get all Payments");
    return this.paymentRepository.findAll().stream()
        .map(this::mapToDto)
        .collect(Collectors.toList());
  }

  @Override
  @Transactional(readOnly = true)
  public PaymentDto findById(Long id) {
    log.debug("Request to get Payment : {}", id);
    return this.paymentRepository.findById(id).map(this::mapToDto).orElse(null);
  }

  @Override
  public PaymentDto create(PaymentDto paymentDto) {
    Order order =
        orderService.findById(paymentDto.getOrderId()).orElseThrow(OrderNotFoundException::new);
    return mapToDto(
        paymentRepository.save(
            Payment.builder()
                .paypalPaymentId(paymentDto.getPaypalPaymentId())
                .status(PaymentStatus.valueOf(paymentDto.getStatus()))
                .order(order)
                .build()));
  }

  @Override
  public void delete(Long id) {
    log.debug("Request to delete Payment : {}", id);
    this.paymentRepository.deleteById(id);
  }

  @Override
  public PaymentDto mapToDto(Payment payment) {
    if (Objects.nonNull(payment)) {
      return PaymentDto.builder()
          .paypalPaymentId(payment.getPaypalPaymentId())
          .orderId(payment.getOrder().getId())
          .status(payment.getStatus().name())
          .build();
    } else {
      return null;
    }
  }
}

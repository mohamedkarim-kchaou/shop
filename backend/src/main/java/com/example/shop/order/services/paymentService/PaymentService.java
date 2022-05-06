package com.example.shop.order.services.paymentService;

import com.example.shop.commons.dto.PaymentDto;
import com.example.shop.order.persistence.model.Payment;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

public interface PaymentService {
  List<PaymentDto> findAll();

  @Transactional(readOnly = true)
  PaymentDto findById(Long id);

  PaymentDto create(PaymentDto paymentDto);

  void delete(Long id);

  PaymentDto mapToDto(Payment payment);
}

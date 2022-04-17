package com.example.shop.services.paymentService;

import com.example.shop.persistence.dto.PaymentDto;
import com.example.shop.persistence.model.Payment;
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

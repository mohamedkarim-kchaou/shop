package com.example.shop.product.services.reviewService;

import com.example.shop.commons.dto.ReviewDto;
import java.util.List;

import com.example.shop.product.persistence.model.Review;
import org.springframework.transaction.annotation.Transactional;

public interface ReviewService {
  List<ReviewDto> findAll();

  @Transactional(readOnly = true)
  ReviewDto findById(Long id);

  ReviewDto create(ReviewDto reviewDto);

  void delete(Long id);

  ReviewDto mapToDto(Review review);

  Review createEntity(ReviewDto reviewDto);
}

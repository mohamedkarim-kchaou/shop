package com.example.shop.productservice.services.reviewService;

import java.util.List;

import com.example.shop.productservice.persistence.dto.ReviewDto;
import com.example.shop.productservice.persistence.model.Review;
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

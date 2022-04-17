package com.example.shop.services.reviewService;

import com.example.shop.persistence.dto.ReviewDto;
import com.example.shop.persistence.model.Review;
import java.util.List;
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

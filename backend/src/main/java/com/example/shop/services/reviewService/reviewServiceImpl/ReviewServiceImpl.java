package com.example.shop.services.reviewService.reviewServiceImpl;

import com.example.shop.persistence.dto.ReviewDto;
import com.example.shop.persistence.model.Review;
import com.example.shop.persistence.repositories.ReviewRepository;
import com.example.shop.services.reviewService.ReviewService;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Slf4j
@Transactional
@Service
public class ReviewServiceImpl implements ReviewService {

  private final ReviewRepository reviewRepository;

  @Override
  public List<ReviewDto> findAll() {
    log.debug("Request to get all Reviews");
    return this.reviewRepository.findAll().stream()
        .map(this::mapToDto)
        .collect(Collectors.toList());
  }

  @Transactional(readOnly = true)
  @Override
  public ReviewDto findById(Long id) {
    log.debug("Request to get Review : {}", id);
    return this.reviewRepository.findById(id).map(this::mapToDto).orElse(null);
  }

  @Override
  public ReviewDto create(ReviewDto reviewDto) {
    log.debug("Request to create Review : {}", reviewDto);
    return mapToDto(
        this.reviewRepository.save(
            new Review(reviewDto.getTitle(), reviewDto.getDescription(), reviewDto.getRating())));
  }

  @Override
  public void delete(Long id) {
    log.debug("Request to delete Review : {}", id);
    this.reviewRepository.deleteById(id);
  }

  @Override
  public ReviewDto mapToDto(Review review) {
    if (Objects.isNull(review)) {
      return null;
    } else {
      return ReviewDto.builder()
          .id(review.getId())
          .description(review.getDescription())
          .rating(review.getRating())
          .title(review.getTitle())
          .build();
    }
  }

  @Override
  public Review createEntity(ReviewDto reviewDto) {
    return reviewRepository.save(
        new Review(reviewDto.getTitle(), reviewDto.getDescription(), reviewDto.getRating()));
  }
}

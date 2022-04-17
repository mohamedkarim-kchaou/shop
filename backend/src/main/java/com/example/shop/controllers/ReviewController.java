package com.example.shop.controllers;

import com.example.shop.persistence.dto.ReviewDto;
import com.example.shop.services.reviewService.ReviewService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/reviews")
public class ReviewController {
  private final ReviewService reviewService;

  @GetMapping
  public List<ReviewDto> findAll() {
    return reviewService.findAll();
  }

  @GetMapping("/{id}")
  public ReviewDto findById(@PathVariable Long id) {
    return this.reviewService.findById(id);
  }

  @PostMapping
  public ReviewDto create(@RequestBody ReviewDto reviewDto) {
    return reviewService.create(reviewDto);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    reviewService.delete(id);
  }
}

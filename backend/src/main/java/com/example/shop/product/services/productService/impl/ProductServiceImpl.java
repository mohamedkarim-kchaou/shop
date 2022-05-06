package com.example.shop.product.services.productService.impl;

import com.example.shop.commons.dto.ProductDto;
import com.example.shop.product.exceptions.ProductNotFoundException;
import com.example.shop.product.persistence.enums.ProductStatus;
import com.example.shop.product.persistence.model.Product;
import com.example.shop.product.persistence.repositories.ProductRepository;
import com.example.shop.product.services.categoryService.CategoryService;
import com.example.shop.product.services.productService.ProductService;
import com.example.shop.product.services.reviewService.ReviewService;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor()
@Transactional
@Slf4j
@Service
public class ProductServiceImpl implements ProductService {
  private final ReviewService reviewService;
  private final ProductRepository productRepository;
  private CategoryService categoryService;

  @Autowired
  public void setCategoryService(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @Override
  public ProductDto mapToDto(Product product) {
    if (Objects.isNull(product)) {
      return null;
    } else {
      return ProductDto.builder()
          .categoryId(product.getCategory().getId())
          .name(product.getName())
          .description(product.getDescription())
          .price(product.getPrice())
          .quantity(product.getQuantity())
          .status(product.getStatus().name())
          .salesCounter(product.getSalesCounter())
          .reviews(
              product.getReviews().stream()
                  .map(reviewService::mapToDto)
                  .collect(Collectors.toSet()))
          .build();
    }
  }

  @Override
  public Product createEntity(ProductDto productDto) {
    return productRepository.save(
        Product.builder()
            .name(productDto.getName())
            .description(productDto.getDescription())
            .price(productDto.getPrice())
            .quantity(productDto.getQuantity())
            .status(ProductStatus.valueOf(productDto.getStatus()))
            .salesCounter(productDto.getSalesCounter())
            .reviews(
                productDto.getReviews().stream()
                    .map(reviewService::createEntity)
                    .collect(Collectors.toSet()))
            .build());
  }

  @Override
  public Product findById(Long id) {
    return productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
  }

  @Override
  public ProductDto findByIdDto(Long id) {
    return mapToDto(productRepository.findById(id).orElseThrow(ProductNotFoundException::new));
  }

  @Override
  public void delete(Long id) {
    productRepository.deleteById(id);
  }

  @Override
  public ProductDto create(ProductDto productDto) {
    return mapToDto(
        productRepository.save(
            Product.builder()
                .name(productDto.getName())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .quantity(productDto.getQuantity())
                .status(ProductStatus.valueOf(productDto.getStatus()))
                .salesCounter(productDto.getSalesCounter())
                .category(categoryService.findById(productDto.getCategoryId()))
                .reviews(
                    productDto.getReviews().stream()
                        .map(reviewService::createEntity)
                        .collect(Collectors.toSet()))
                .build()));
  }

  @Override
  public List<ProductDto> findAll() {
    return productRepository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
  }
}

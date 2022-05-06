package com.example.shop.product.services.categoryService.impl;

import com.example.shop.commons.dto.CategoryDto;
import com.example.shop.product.exceptions.CategoryNotFoundException;
import com.example.shop.product.persistence.model.Category;
import com.example.shop.product.persistence.repositories.CategoryRepository;
import com.example.shop.product.services.categoryService.CategoryService;
import com.example.shop.product.services.productService.ProductService;
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
@Transactional
public class CategoryServiceImpl implements CategoryService {
  private final CategoryRepository categoryRepository;
  private ProductService productService;

  @Autowired
  public void setProductService(ProductService productService) {
    this.productService = productService;
  }

  @Override
  public List<CategoryDto> findAll() {
    log.debug("Request to get all Categories");
    return categoryRepository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
  }

  @Override
  public CategoryDto mapToDto(Category category) {
    if (Objects.isNull(category)) {
      return null;
    } else {
      return CategoryDto.builder()
          .name(category.getName())
          .description(category.getDescription())
          .products(
              category.getProducts().stream()
                  .map(productService::mapToDto)
                  .collect(Collectors.toSet()))
          .build();
    }
  }

  @Transactional(readOnly = true)
  @Override
  public CategoryDto findByIdDto(Long id) {
    log.debug("Request to get Category : {}", id);
    return categoryRepository
        .findById(id)
        .map(this::mapToDto)
        .orElseThrow(CategoryNotFoundException::new);
  }

  @Transactional(readOnly = true)
  @Override
  public Category findById(Long id) {
    log.debug("Request to get Category : {}", id);
    return categoryRepository.findById(id).orElseThrow(CategoryNotFoundException::new);
  }

  @Override
  public void delete(Long id) {
    categoryRepository.deleteById(id);
  }

  @Override
  public CategoryDto create(CategoryDto categoryDto) {
    return mapToDto(
        categoryRepository.save(
            Category.builder()
                .description(categoryDto.getDescription())
                .name(categoryDto.getName())
                .products(
                    categoryDto.getProducts().stream()
                        .map(productService::createEntity)
                        .collect(Collectors.toSet()))
                .build()));
  }
}

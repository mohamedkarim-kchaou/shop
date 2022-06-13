package com.example.shop.productservice.services.categoryService;

import com.example.shop.productservice.persistence.dto.CategoryDto;
import com.example.shop.productservice.persistence.model.Category;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

public interface CategoryService {
  List<CategoryDto> findAll();

  CategoryDto mapToDto(Category category);

  @Transactional(readOnly = true)
  CategoryDto findByIdDto(Long id);

  @Transactional(readOnly = true)
  Category findById(Long id);

  void delete(Long id);

  CategoryDto create(CategoryDto categoryDto);
}

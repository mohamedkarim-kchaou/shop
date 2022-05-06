package com.example.shop.product.services.categoryService;

import com.example.shop.commons.dto.CategoryDto;
import com.example.shop.product.persistence.model.Category;
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

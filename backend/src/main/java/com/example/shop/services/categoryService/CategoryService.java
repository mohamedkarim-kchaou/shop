package com.example.shop.services.categoryService;

import com.example.shop.persistence.dto.CategoryDto;
import com.example.shop.persistence.model.Category;
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

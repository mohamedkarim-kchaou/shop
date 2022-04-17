package com.example.shop.controllers;

import com.example.shop.persistence.dto.CategoryDto;
import com.example.shop.services.categoryService.CategoryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/categories")
public class CategoryController {
  private final CategoryService categoryService;

  @GetMapping
  public List<CategoryDto> findAll() {
    return categoryService.findAll();
  }

  @GetMapping("/{id}")
  public CategoryDto findById(@PathVariable Long id) {
    return categoryService.findByIdDto(id);
  }

  @PostMapping
  public CategoryDto create(CategoryDto categoryDto) {
    return categoryService.create(categoryDto);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    categoryService.delete(id);
  }
}

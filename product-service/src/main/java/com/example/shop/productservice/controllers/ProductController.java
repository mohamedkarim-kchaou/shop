package com.example.shop.productservice.controllers;

import com.example.shop.productservice.persistence.dto.ProductDto;
import com.example.shop.productservice.services.productService.ProductService;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/products")
public class ProductController {
  private final ProductService productService;

  @GetMapping
  public List<ProductDto> findAll() {
    return productService.findAll();
  }

  @GetMapping("/{id}")
  public ProductDto findById(@PathVariable Long id) {
    return productService.findByIdDto(id);
  }

  @PostMapping
  public ProductDto create(@RequestBody ProductDto productDto) {
    return productService.create(productDto);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    productService.delete(id);
  }
}

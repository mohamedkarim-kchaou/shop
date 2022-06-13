package com.example.shop.productservice.services.productService;

import com.example.shop.productservice.persistence.dto.ProductDto;
import com.example.shop.productservice.persistence.model.Product;

import java.util.List;

public interface ProductService {
  ProductDto mapToDto(Product product);

  Product createEntity(ProductDto productDto);

  Product findById(Long id);

  ProductDto findByIdDto(Long id);

  void delete(Long id);

  ProductDto create(ProductDto productDto);

  List<ProductDto> findAll();
}

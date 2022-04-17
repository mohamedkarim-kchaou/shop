package com.example.shop.services.productService;

import com.example.shop.persistence.dto.ProductDto;
import com.example.shop.persistence.model.Product;
import java.util.List;
import java.util.Optional;

public interface ProductService {
  ProductDto mapToDto(Product product);

  Product createEntity(ProductDto productDto);

  Optional<Product> findById(Long id);

  ProductDto findByIdDto(Long id);

  void delete(Long id);

  ProductDto create(ProductDto productDto);

  List<ProductDto> findAll();
}

package com.example.shop.productservice.persistence.repositories;

import com.example.shop.productservice.persistence.model.Category;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

  List<Category> findAll();
}

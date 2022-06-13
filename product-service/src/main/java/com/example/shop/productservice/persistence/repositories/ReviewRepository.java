package com.example.shop.productservice.persistence.repositories;

import com.example.shop.productservice.persistence.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {}

package com.wp.vjezbe7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wp.vjezbe7.models.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}

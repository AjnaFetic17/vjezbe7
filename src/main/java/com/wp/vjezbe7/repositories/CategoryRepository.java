package com.wp.vjezbe7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wp.vjezbe7.models.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}

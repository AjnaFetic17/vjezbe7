package com.wp.vjezbe7.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wp.vjezbe7.models.entities.Category;
import com.wp.vjezbe7.models.in.CategoryIn;
import com.wp.vjezbe7.models.out.CategoryOut;

@Service
public interface CategoryService {
    List<CategoryOut> getAll();

    CategoryOut save(CategoryIn categoryIn);

    CategoryOut edit(Integer id, CategoryIn categoryIn);

    boolean delete(Integer id);

    Category getByIdDB(Integer id);
}

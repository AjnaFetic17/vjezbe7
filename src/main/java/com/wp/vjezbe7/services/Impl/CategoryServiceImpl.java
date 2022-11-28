package com.wp.vjezbe7.services.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wp.vjezbe7.models.entities.Category;
import com.wp.vjezbe7.models.in.CategoryIn;
import com.wp.vjezbe7.models.out.CategoryOut;
import com.wp.vjezbe7.repositories.CategoryRepository;
import com.wp.vjezbe7.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository _CategoryRepository;

    @Override
    public List<CategoryOut> getAll() {
        List<Category> categories = _CategoryRepository.findAll();
        List<CategoryOut> categoryOuts = new ArrayList<>();
        for (Category category : categories) {
            categoryOuts.add(new CategoryOut(category));
        }
        return categoryOuts;
    }

    @Override
    public CategoryOut save(CategoryIn categoryIn) {
        Category category = new Category(categoryIn);
        _CategoryRepository.save(category);
        return new CategoryOut(category);
    }

    @Override
    public CategoryOut edit(Integer id, CategoryIn categoryIn) {
        Category category = _CategoryRepository.findById(id).get();
        if (category != null) {
            category.setName(categoryIn.getName());
            _CategoryRepository.save(category);
            return new CategoryOut(category);
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        Category category = _CategoryRepository.findById(id).get();
        if (category != null) {
            _CategoryRepository.delete(category);
            return true;
        }
        return false;
    }

    @Override
    public Category getByIdDB(Integer id) {
        return _CategoryRepository.findById(id).get();
    }

}

package com.wp.vjezbe7.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wp.vjezbe7.models.in.CategoryIn;
import com.wp.vjezbe7.models.out.CategoryOut;
import com.wp.vjezbe7.services.CategoryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService _CategoryService;

    @GetMapping(value = "/")
    public List<CategoryOut> getAllCategories() {
        return _CategoryService.getAll();
    }

    @PostMapping(value = "/")
    public CategoryOut addCategory(@RequestBody CategoryIn categoryIn) {
        return _CategoryService.save(categoryIn);
    }

    @PutMapping(value = "/")
    public CategoryOut editCategory(@RequestParam("id") String id, @RequestBody CategoryIn categoryIn) {
        return _CategoryService.edit(Integer.parseInt(id), categoryIn);
    }

    @DeleteMapping(value = "/")
    public boolean deteleCategory(@RequestParam("id") String id) {
        return _CategoryService.delete(Integer.parseInt(id));
    }
}

package com.wp.vjezbe7.models.out;

import com.wp.vjezbe7.models.entities.Category;

public class CategoryOut {

    private Integer id;

    private String name;

    public CategoryOut() {
    }

    public CategoryOut(Category category) {
        id = category.getId();
        name = category.getName();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

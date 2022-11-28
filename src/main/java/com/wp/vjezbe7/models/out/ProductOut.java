package com.wp.vjezbe7.models.out;

import com.wp.vjezbe7.models.entities.Product;

public class ProductOut {

    private Integer id;

    private String name;

    private String description;

    private double unitPrice;

    private Integer unitQuantity;

    private String imageURL;

    private String category;

    public ProductOut() {
    }

    public ProductOut(Product product) {
        name = product.getName();
        description = product.getDescription();
        imageURL = product.getImageURL();
        unitPrice = product.getUnitPrice();
        unitQuantity = product.getUnitQuantity();
        category = product.getCategory().getName();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getUnitQuantity() {
        return unitQuantity;
    }

    public void setUnitQuantity(Integer unitQuantity) {
        this.unitQuantity = unitQuantity;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

}

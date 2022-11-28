package com.wp.vjezbe7.services.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wp.vjezbe7.models.entities.Category;
import com.wp.vjezbe7.models.entities.Product;
import com.wp.vjezbe7.models.in.ProductIn;
import com.wp.vjezbe7.models.out.ProductOut;
import com.wp.vjezbe7.repositories.ProductRepository;
import com.wp.vjezbe7.services.CategoryService;
import com.wp.vjezbe7.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository _ProductRepository;

    @Autowired
    private CategoryService _CategoryService;

    @Override
    public List<ProductOut> getAll() {

        List<Product> products = _ProductRepository.findAll();
        List<ProductOut> productOuts = new ArrayList<>();

        for (Product product : products) {
            productOuts.add(new ProductOut(product));
        }
        return productOuts;
    }

    @Override
    public ProductOut save(ProductIn productIn) {
        Product product = new Product(productIn);

        Category category = _CategoryService.getByIdDB(productIn.getCategoryId());
        if (category != null) {
            product.setCategory(category);
            _ProductRepository.save(product);
            return new ProductOut(product);
        }
        return null;
    }

    @Override
    public ProductOut edit(Integer id, ProductIn productIn) {
        Product product = _ProductRepository.findById(id).get();
        if (product != null) {
            product.setName(productIn.getName());
            product.setDescription(productIn.getDescription());
            product.setUnitPrice(productIn.getUnitPrice());
            product.setUnitQuantity(productIn.getUnitQuantity());
            product.setImageURL(productIn.getImageURL());
            Category category = _CategoryService.getByIdDB(productIn.getCategoryId());
            product.setCategory(category);
            _ProductRepository.save(product);
            return new ProductOut(product);
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        Product product = _ProductRepository.findById(id).get();
        if (product != null) {
            _ProductRepository.delete(product);
            return true;
        }
        return false;
    }

}

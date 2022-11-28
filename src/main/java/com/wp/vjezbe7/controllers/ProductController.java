package com.wp.vjezbe7.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wp.vjezbe7.models.in.ProductIn;
import com.wp.vjezbe7.models.out.ProductOut;
import com.wp.vjezbe7.services.ProductService;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService _ProductService;

    @GetMapping(value = "/")
    public List<ProductOut> getAll() {
        return _ProductService.getAll();
    }

    @PostMapping(value = "/")
    public ProductOut save(@RequestBody ProductIn productIn) {
        return _ProductService.save(productIn);
    }

    @PutMapping(value = "/")
    public ProductOut edit(@RequestParam("id") String id, @RequestBody ProductIn productIn) {
        return _ProductService.edit(Integer.parseInt(id), productIn);
    }

    @DeleteMapping(value = "/")
    public boolean delete(@RequestParam("id") String id) {
        return _ProductService.delete(Integer.parseInt(id));
    }
}

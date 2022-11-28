package com.wp.vjezbe7.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wp.vjezbe7.models.in.ProductIn;
import com.wp.vjezbe7.models.out.ProductOut;

@Service
public interface ProductService {

    List<ProductOut> getAll();

    ProductOut save(ProductIn productIn);

    ProductOut edit(Integer id, ProductIn productIn);

    boolean delete(Integer id);
}

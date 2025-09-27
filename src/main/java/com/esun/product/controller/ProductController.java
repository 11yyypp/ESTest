package com.esun.product.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esun.product.model.Product;
import com.esun.product.model.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productSvc;

    @GetMapping("/getAll")
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productSvc.getAll());
    }
}


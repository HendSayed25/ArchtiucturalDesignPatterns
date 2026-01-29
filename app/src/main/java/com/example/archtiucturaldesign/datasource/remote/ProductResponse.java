package com.example.archtiucturaldesign.datasource.remote;

import com.example.archtiucturaldesign.model.Product;

import java.util.List;

public class ProductResponse {
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }
}
package com.example.archtiucturaldesign.data.products.datasource.remote;

import com.example.archtiucturaldesign.data.products.model.Product;

import java.util.List;

public class ProductResponse {
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }
}